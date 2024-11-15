import java.util.Scanner;

public class SafeInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Testing the getNonZeroLenString method
        String result = getNonZeroLenString(in, "Enter a non-empty string");
        System.out.println("You entered: " + result);
    }

    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }
    public static int getInt(Scanner pipe, String prompt) {
        int retValue = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next(); // Clear the invalid input
            }
            pipe.nextLine(); // Clear the newline character
        } while (!valid);

        return retValue;
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double retValue = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.next(); // Clear the invalid input
            }
            pipe.nextLine(); // Clear the newline character
        } while (!valid);

        return retValue;
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retValue = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retValue = pipe.nextInt();
                if (retValue >= low && retValue <= high) {
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.next(); // Clear the invalid input
            }
            pipe.nextLine(); // Clear the newline character
        } while (!valid);

        return retValue;
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retValue = 0;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retValue = pipe.nextDouble();
                if (retValue >= low && retValue <= high) {
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.next(); // Clear the invalid input
            }
            pipe.nextLine(); // Clear the newline character
        } while (!valid);

        return retValue;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        boolean valid = false;
        boolean retValue = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y")) {
                retValue = true;
                valid = true;
            } else if (response.equals("N")) {
                retValue = false;
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!valid);

        return retValue;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response;
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                valid = true;
            } else {
                System.out.println("Invalid input. Please match the pattern: " + regEx);
            }
        } while (!valid);

        return response;
    }

}
