import java.util.Scanner;

// Custom Exception Class
class NumberFormatException extends Exception {
    public NumberFormatException(String message) {
        super(message);
    }
}

public class NumberToTextConverter {
    // Arrays for storing string representations of digits
    private static final String[] hundreds = {
        "", "a hundred", "two hundred", "three hundred", "four hundred", "five hundred", "six hundred", "seven hundred", "eight hundred", "nine hundred"
    };

    private static final String[] tens = {
        "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    private static final String[] units = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    private static final String[] teens = {
        "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    // Method for converting number to text
    public static String convertNumberToText(int number) throws NumberFormatException {
        if (number < 100 || number > 999) {
            // Throw an exception if the number is not three-digit
            throw new NumberFormatException("The number must be three digits!");
        }

        int h = number / 100;         // Hundreds place
        int t = (number / 10) % 10;   // Tens place
        int u = number % 10;          // Units digit

        StringBuilder result = new StringBuilder();

        // Adding hundreds
        result.append(hundreds[h]).append(" ");
        
        // Adding word "and" except for number that can divide by 100
        if (t != 0 || u != 0) {
            result.append("and ");
        }

        // Process tens and units
        if (t == 1) {
            // If ten is 1 (numbers from 10 to 19):
            result.append(teens[u]);
        } else {
            result.append(tens[t]).append(" ");
            result.append(units[u]);
        }

        return result.toString().trim();
    }

    // Main method in the program
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number;
        System.out.println("Write the number you want to convert, write 0 to exit.");
        number = input.nextInt(); input.nextLine();

        while (number != 0) {
            try {
                // Convert number to text
                String text = convertNumberToText(number);
                System.out.println("Number " + number + " converted to English text: " + text);
            } catch (NumberFormatException e) {
                // Handling the exception
                System.out.println("Error: " + e.getMessage());
            }
            number = input.nextInt(); input.nextLine();
        }
    }
}
