import java.util.Scanner;

public class Name {
    private Object value;

    // Конструктор, позволяющий задать начальное значение
    public Name(Object value) {
        this.value = value;
    }

    // Метод для установки нового значения
    public void setValue(Object value) {
        this.value = value;
        System.out.println("Set successfully.");
    }

    // Метод для получения значения с определением типа
    public String getValueInfo() {
        if (value == null) {
            return "Null type: null";
        } else if (value instanceof Integer) {
            return "Integer: " + value;
        } else if (value instanceof Double) {
            return "Double (floating-point): " + value;
        } else if (value instanceof String) {
            return "String: " + value;
        } else if (value instanceof Boolean) {
            return "Boolean: " + value;
        } else if (value instanceof Character) {
            return "Char: " + value;
        } else {
            return "Other type: " + value.toString();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Name name = new Name(null);

        System.out.println("Menu:");
        System.out.println("1) Add an integer into class.");
        System.out.println("2) Add a double into class.");
        System.out.println("3) Add a string into class.");
        System.out.println("4) Add a bool into class.");
        System.out.println("5) Add a char into class.");
        System.out.println("6) Get the class value.");
        System.out.println("0) EXIT");

        int choice = 7;
        while (choice != 0) {
            System.out.print("Your choice: ");
            choice = input.nextInt(); input.nextLine();
            
            switch (choice) {
                case 1:
                    int i;
                    System.out.print("Write the integer: ");
                    i = input.nextInt(); input.nextLine();
                    name.setValue(i);
                    break;

                case 2:
                    double d;
                    System.out.print("Write the double: ");
                    d = input.nextDouble(); input.nextLine();
                    name.setValue(d);
                    break;

                case 3:
                    String s;
                    System.out.print("Write the string: ");
                    s = input.nextLine();
                    name.setValue(s);
                    break;

                case 4:
                    boolean b;
                    System.out.print("Write the boolean: ");
                    b = input.nextBoolean(); input.nextLine();
                    name.setValue(b);
                    break;

                case 5:
                    char c;
                    System.out.print("Write the char: ");
                    c = input.next().charAt(0);
                    name.setValue(c);
                    break;

                case 6:
                    System.out.println(name.getValueInfo());
                    break;
            
                default:
                    break;
            }
        }

        input.close();
    }
}