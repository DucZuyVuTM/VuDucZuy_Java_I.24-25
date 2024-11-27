import java.util.Scanner;

public class AssociativeSet {
    // Properties
    private String[] elements; // Contains all the elements of the array/set
    private int[] counts;      // The amount of elements
    private int size;          // The current size of the array

    // Methods

    // Constructor
    public AssociativeSet(int capacity) {
        elements = new String[capacity];
        counts = new int[capacity];
        size = 0;
    }

    // Add element to array
    public void add(String element) {
        int index = findElementByName(element);

        if (index == -1) {
            // Element doesn't exist in array. Add it to the array.
            if (size < elements.length) {
                elements[size] = element;
                counts[size] = 1;
                size++;
            } else {
                System.out.println("Set is full, cannot add more elements.");
            }
        } else {
            // Element exists. Increase the amount of that element.
            counts[index]++;
        }
    }

    // Find an element by name in array
    public int findElementByName(String element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1; // Element not found
    }

    // Find an element by index in array
    public String findElementByIndex(int index) {
        if (index >= size) {
            System.out.print("Exception in thread 'main' java.lang.ArrayIndexOutOfBoundsException: ");
            System.out.println("Index " + index + " out of bounds for length " + size);
            System.exit(1);
        }

        if (index < 0) {
            System.out.println("Index must be more than -1.");
            System.exit(1);
        }

        return elements[index];
    }

    // Return the amount of an element
    public int getCount(String element) {
        int index = findElementByName(element);
        if (index != -1) {
            return counts[index];
        }
        return 0;
    }

    // Print all the elements with their amount
    public void printSet() {
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i] + ": " + counts[i]);
        }
    }

    // Main part of the program
    public static void main(String[] args) {
        int length, choice, index;
        String name;
        Scanner input = new Scanner(System.in);

        System.out.print("Write the length of your associative set: ");
        length = input.nextInt(); input.nextLine();

        AssociativeSet set = new AssociativeSet(length);

        System.out.println("Menu: ");
        System.out.println("1) Add an element.");
        System.out.println("2) Find an element by name.");
        System.out.println("3) Find an element by index.");
        System.out.println("4) Return the amount of an element.");
        System.out.println("5) Print all the elements with their amount.");
        System.out.println("6) Exit program.");

        System.out.print("Write the choice: ");
        choice = input.nextInt(); input.nextLine();

        while (choice != 6) {
            if (choice == 1) {
                System.out.print("Write the element to add: ");
                name = input.nextLine();
                set.add(name);
            }

            if (choice == 2) {
                System.out.print("Write the element to find: ");
                name = input.nextLine();
                index = set.findElementByName(name);
                if (index == -1) {
                    System.out.println("Element not found.");
                } else {
                    System.out.println("Element " + name + " has an index " + index + " in the array.");
                }
            }

            if (choice == 3) {
                System.out.print("Write the index to print element: ");
                index = input.nextInt(); input.nextLine();
                name = set.findElementByIndex(index);
                System.out.println("For index " + index + " we have an element: " + name);
            }

            if (choice == 4) {
                System.out.print("Write the element to print the amount: ");
                name = input.nextLine();
                System.out.println("Count of " + name + ": " + set.getCount(name));
            }

            if (choice == 5) {
                set.printSet();
            }

            System.out.print("Write the choice: ");
            choice = input.nextInt(); input.nextLine();
        }
    }
}
