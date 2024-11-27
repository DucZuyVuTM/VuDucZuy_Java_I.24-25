import java.util.Scanner;

public class Converter<T> {
    // Property
    private T value;

    // Constructor
    public Converter(T value) {
        this.value = value;
    }

    // Methods for all 4 data types
    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Converter<T> cloneConverter() {
        return new Converter<>(this.value);
    }

    public void clear() {
        this.value = null;
    }

    public void modify(T newValue) {
        this.value = newValue;
        System.out.println("Successfully modified");
    }

    // Methods for type integer
    public Integer add(Integer a) {
        if (value instanceof Integer) {
            return (Integer) value + a;
        }
        throw new UnsupportedOperationException("Value is not an Integer");
    }

    public Integer subtract(Integer a) {
        if (value instanceof Integer) {
            return (Integer) value - a;
        }
        throw new UnsupportedOperationException("Value is not an Integer");
    }

    public Integer multiply(Integer a) {
        if (value instanceof Integer) {
            return (Integer) value * a;
        }
        throw new UnsupportedOperationException("Value is not an Integer");
    }

    public Integer[] divideWithRemainder(Integer divisor) {
        if (value instanceof Integer) {
            int dividend = ((Number) value).intValue();

            if (divisor == 0) {
                throw new ArithmeticException("Division by zero");
            }

            // Find the quotient
            int quotient = dividend / divisor;
            // Find the remainder
            int remainder = dividend - (quotient * divisor);

            return new Integer[] {quotient, remainder}; // Return the array that contains quotient and remainder
        }
        throw new IllegalArgumentException("Both values must be numbers");
    }

    // Method for type string
    public String concatenate(String a) {
        if (value instanceof String) {
            return (String) value + a;
        }
        throw new UnsupportedOperationException("Value is not a String");
    }

    // Methods for type bollean
    public Boolean and(Boolean a) {
        if (value instanceof Boolean) {
            return (Boolean) value && a;
        }
        throw new UnsupportedOperationException("Value is not a Boolean");
    }

    public Boolean or(Boolean a) {
        if (value instanceof Boolean) {
            return (Boolean) value || a;
        }
        throw new UnsupportedOperationException("Value is not a Boolean");
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            int intValue; String strValue; boolean boolValue; char charValue;

            Integer[] results;

            Converter<Integer> clonedIntClass = new Converter<>(null);
            Converter<String> clonedStringClass = new Converter<>(null);
            Converter<Boolean> clonedBoolClass = new Converter<>(null);
            Converter<Character> clonedCharClass = new Converter<>(null);

            System.out.print("Write your integer: ");
            intValue = input.nextInt(); input.nextLine();
            Converter<Integer> IntClass = new Converter<>(intValue);

            System.out.print("Write your string: ");
            strValue = input.nextLine();
            Converter<String> StringClass = new Converter<>(strValue);

            System.out.print("Write your boolean value: ");
            boolValue = input.nextBoolean(); input.nextLine();
            Converter<Boolean> BoolClass = new Converter<>(boolValue);

            System.out.print("Write your char value: ");
            charValue = input.next().charAt(0);
            Converter<Character> CharClass = new Converter<>(charValue);

            System.out.println("Menu:");
            System.out.println("1) Modify the integer value.");
            System.out.println("2) Get the integer value.");
            System.out.println("3) Clone the integer value.");
            System.out.println("4) Get the cloned integer.");
            System.out.println("5) Clear the integer value.");
            System.out.println();

            System.out.println("6) Modify the string value.");
            System.out.println("7) Get the string value.");
            System.out.println("8) Clone the string value.");
            System.out.println("9) Get the cloned string.");
            System.out.println("10) Clear the string value.");
            System.out.println();

            System.out.println("11) Modify the boolean value.");
            System.out.println("12) Get the boolean value.");
            System.out.println("13) Clone the boolean value.");
            System.out.println("14) Get the cloned integer.");
            System.out.println("15) Clear the boolean value.");
            System.out.println();

            System.out.println("16) Modify the char value.");
            System.out.println("17) Get the char value.");
            System.out.println("18) Clone the char value.");
            System.out.println("19) Get the cloned integer.");
            System.out.println("20) Clear the char value.");
            System.out.println();

            System.out.println("21) Add two integers.");
            System.out.println("22) Subtract two integers.");
            System.out.println("23) Multiply two integers.");
            System.out.println("24) Divide two integers.");
            System.out.println();
            
            System.out.println("25) Concatenate the string value.");
            System.out.println();

            System.out.println("26) Logical operation AND for 2 boolean values.");
            System.out.println("27) Logical operation OR for 2 boolean values.");
            System.out.println();

            System.out.println("0) Exit");
            System.out.println();

            int choice = 1;
            while (choice != 0) {
                System.out.print("Your choice: ");
                choice = input.nextInt(); input.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("New integer value: ");
                        intValue = input.nextInt(); input.nextLine();
                        IntClass.modify(intValue);
                        break;

                    case 2:
                        System.out.println("Integer value: " + IntClass.getValue());
                        break;

                    case 3:
                        clonedIntClass = IntClass.cloneConverter();
                        System.out.println("Cloned succesfully");
                        break;

                    case 4:
                        System.out.println("Cloned integer value: " + clonedIntClass.getValue());
                        break;

                    case 5:
                        IntClass.clear();
                        System.out.println("Class was clear");
                        break;

                    // -------

                    case 6:
                        System.out.print("New string value: ");
                        strValue = input.nextLine();
                        StringClass.modify(strValue);
                        break;

                    case 7:
                        System.out.println("String value: " + StringClass.getValue());
                        break;

                    case 8:
                        clonedStringClass = StringClass.cloneConverter();
                        System.out.println("Cloned succesfully");
                        break;

                    case 9:
                        System.out.println("Cloned string value: " + clonedStringClass.getValue());
                        break;

                    case 10:
                        StringClass.clear();
                        System.out.println("Class was clear");
                        break;

                    // -------

                    case 11:
                        System.out.print("New boolean value: ");
                        boolValue = input.nextBoolean(); input.nextLine();
                        BoolClass.modify(boolValue);
                        break;

                    case 12:
                        System.out.println("Boolean value: " + BoolClass.getValue());
                        break;

                    case 13:
                        clonedBoolClass = BoolClass.cloneConverter();
                        System.out.println("Cloned succesfully");
                        break;

                    case 14:
                        System.out.println("Cloned boolean value: " + clonedBoolClass.getValue());
                        break;

                    case 15:
                        BoolClass.clear();
                        System.out.println("Class was clear");
                        break;

                    // -------
                
                    case 16:
                        System.out.print("New char value: ");
                        charValue = input.next().charAt(0);
                        CharClass.modify(charValue);
                        break;

                    case 17:
                        System.out.println("Char value: " + CharClass.getValue());
                        break;

                    case 18:
                        clonedCharClass = CharClass.cloneConverter();
                        System.out.println("Cloned succesfully");
                        break;

                    case 19:
                        System.out.println("Cloned char value: " + clonedCharClass.getValue());
                        break;

                    case 20:
                        CharClass.clear();
                        System.out.println("Class was clear");
                        break;

                    // -------

                    case 21:
                        System.out.print("Write the integer to add: ");
                        intValue = input.nextInt(); input.nextLine();
                        System.out.println(IntClass.getValue() + " + " + intValue + " = " + IntClass.add(intValue));
                        IntClass.setValue(IntClass.add(intValue));
                        break;

                    case 22:
                        System.out.print("Write the integer to subtract: ");
                        intValue = input.nextInt(); input.nextLine();
                        System.out.println(IntClass.getValue() + " - " + intValue + " = " + IntClass.subtract(intValue));
                        IntClass.setValue(IntClass.subtract(intValue));
                        break;

                    case 23:
                        System.out.print("Write the integer to multiply: ");
                        intValue = input.nextInt(); input.nextLine();
                        System.out.println(IntClass.getValue() + " * " + intValue + " = " + IntClass.multiply(intValue));
                        IntClass.setValue(IntClass.multiply(intValue));
                        break;

                    case 24:
                        System.out.print("Write the integer to divide: ");
                        intValue = input.nextInt(); input.nextLine();
                        results = IntClass.divideWithRemainder(intValue);
                        results = IntClass.divideWithRemainder(intValue);
                        System.out.println("Quotient: " + results[0]);
                        System.out.println("Remainder: " + results[1]);
                        System.out.println("(" + IntClass.getValue() + " - " + results[1] +  ")" + " / " + intValue + " = " + results[0]);
                        IntClass.setValue(results[0]);
                        break;

                    // -------

                    case 25:
                        System.out.print("Write the string to concatenate: ");
                        strValue = input.nextLine();
                        System.out.println(StringClass.getValue() + " + " + strValue + " = " + StringClass.concatenate(strValue));
                        StringClass.setValue(StringClass.concatenate(strValue));
                        break;

                    // -------

                    case 26:
                        System.out.print("Write the boolean value to calculate AND operation: ");
                        boolValue = input.nextBoolean(); input.nextLine();
                        System.out.println(BoolClass.getValue() + " && " + boolValue + " = " + BoolClass.and(boolValue));
                        BoolClass.setValue(BoolClass.and(boolValue));
                        break;

                    case 27:
                        System.out.print("Write the boolean value to calculate OR operation: ");
                        boolValue = input.nextBoolean(); input.nextLine();
                        System.out.println(BoolClass.getValue() + " || " + boolValue + " = " + BoolClass.or(boolValue));
                        BoolClass.setValue(BoolClass.or(boolValue));
                        break;

                    // -------

                    default:
                        break;
                }
            }

            System.out.println("Program exited.");
            input.close();

        } catch (Exception e) {
            // Every exception is caught here
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
