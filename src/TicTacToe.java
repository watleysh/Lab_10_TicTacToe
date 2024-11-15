import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];
    private static Scanner in = new Scanner(System.in);

    //Pseudocode
    // class TicTacToe
    //Main()
    //String Player ="x"
    // clearBoard();
    //input "make your move"
    //for (int 1=0; i < 9;i++)
    // if (i=1 || 3 || 5 || 7 || 9)
    //    playerStatus = "x"
    // else
    //    playerStatus = "o"
    //	do {
    //	    row = SafeInput.getRangedInt(in, "Enter your row coordinate", 3, 1) - 1;
    //		col = SafeInput.getRangedInt(in, "Enter your column coordinate", 3, 1) - 1;
    //	}
    //	while(!isValidMove(row, col));
    //		board[row][col] = currentPlayer
    //		numPlays += 1
    //		if (numPlays > 5)
    //			{
    //				if (isWin)
    //				{
    //					output "currentPlayer + " wins!"
    //				}
    //			else if (numPlays > 7)
    //			{
    //				if (isTie)
    //				{
    //					output "It's a tie!"}
    //					}
    //				}
    //			}


    public static void main(String[] args) {
        String playerString = " X ";
        String playerMove = "X"; // Starting player
        int row;
        int col;
        int plays; // Counter for # of plays

        do {
            clearBoard();
            playerString = " X ";
            playerMove = "X"; // X always first
            plays = 0;
            boolean gameOver = false;

            while (!gameOver) {
                System.out.println("It's " + playerMove + "'s turn!");

                do {
                    row = SafeInput.getRangedInt(in, "Enter your row coordinate", 1, 3) - 1;
                    col = SafeInput.getRangedInt(in, "Enter your column coordinate", 1, 3) - 1;
                } while (!isValidMove(row, col));

                board[row][col] = playerString;
                display(); // Refresh display
                plays += 1;

                // Game Check
                if (plays >= 4) { // Check for win
                    if (isWin(playerString)) {
                        System.out.println(playerMove + " Wins!");
                        gameOver = true;
                    } else if (plays >= 9) { // Check for tie
                        if (isTie()) {
                            System.out.println("It's a tie!");
                            gameOver = true;
                        }
                    }
                }

                // Toggle player
                if (!gameOver) {
                    playerString = playerString.equals(" X ") ? " O " : " X ";
                    playerMove = playerMove.equals("X") ? "O" : "X";
                }
            }
        } while (SafeInput.getYNConfirm(in, "Play Again?"));
    }

    // Display board here
    private static void display() {
        String displayBoard = "";
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (c == COL - 1) {
                    displayBoard += board[r][c];
                } else {
                    displayBoard += board[r][c] + "|";
                }
            }
            if (r != ROW - 1) {
                displayBoard += "\n---+---+---\n";
            }
        }
        System.out.println(displayBoard);
    }

    // clear  board
    private static void clearBoard() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                board[r][c] = "   ";
            }
        }
    }

    // check if the move is valid
    private static boolean isValidMove(int row, int col) {
        return (board[row][col].equals("   "));
    }

    // row win?
    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }

    //  column win?
    private static boolean isColWin(String player) {
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;
    }

    //diagonal win?
    private static boolean isDiagonalWin(String player) {
        return (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) ||
                (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player));
    }

    // Check  any win
    private static boolean isWin(String player) {
        return isColWin(player) || isRowWin(player) || isDiagonalWin(player);
    }

    // Check for a tie
    private static boolean isTie() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (board[r][c].equals("   ")) {
                    return false; //  empty spot= not a tie
                }
            }
        }
        return true;
    }
}
