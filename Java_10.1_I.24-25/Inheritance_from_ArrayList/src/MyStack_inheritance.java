import java.util.ArrayList;
import java.util.Scanner;

class Influencer {
    // Properties
    private String name;
    private int age;

    // Constructor
    Influencer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "\"Name: " + name + "; Age: " + age + "\"";
    }
}

public class MyStack_inheritance extends ArrayList<Object> {
    public MyStack_inheritance() {
        super();
    }

    public MyStack_inheritance(MyStack_inheritance otherStack) {
        super(otherStack);
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return get(size() - 1);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return remove(size() - 1);
    }

    public void push(Object o) {
        add(o);
        System.out.println("Added successfully");
    }

    public MyStack_inheritance deepCopy() {
        return new MyStack_inheritance(this);
    }

    public void reverse() {
        MyStack_inheritance revStack = deepCopy();
        System.out.print("MyStack: ");
        while (!revStack.isEmpty()) {
            System.out.print(revStack.pop() + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "MyStack: " + super.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyStack_inheritance mystack = new MyStack_inheritance();
        MyStack_inheritance copiedStack = new MyStack_inheritance();
        int choice = 15;

        System.out.println("Menu:");
        System.out.println("1)  Check if the stack is empty.");
        System.out.println("2)  Get the size of the stack.");
        System.out.println("3)  Print the \"first out\" element of the stack.");
        System.out.println("4)  Print the \"first out\" element and delete it from the stack.");
        System.out.println("5)  Push a new integer element into the stack.");
        System.out.println("6)  Push a new string element into the stack.");
        System.out.println("7)  Push a new boolean element into the stack.");
        System.out.println("8)  Push a new char element into the stack.");
        System.out.println("9)  Push a new \"influencer\" element into the stack.");
        System.out.println("10) Print all the elements in the stack.");
        System.out.println("11) Print all the elements in reverse order.");
        System.out.println("12) Deep copy a stack into another.");
        System.out.println("13) Print all the elements in the copied stack.");
        System.out.println("14) Print all the copied elements in reverse order.");
        System.out.println("0)  EXIT");

        while (choice != 0) {
            System.out.print("Your choice: ");
            choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1:
                    boolean isempty = mystack.isEmpty();
                    if (isempty) {
                        System.out.println("The stack is empty");
                    } else {
                        System.out.println("The system is not empty");
                    }
                    break;

                case 2:
                    System.out.println("The size of stack now is " + mystack.size());
                    break;

                case 3:
                    Object first_toPeek = mystack.peek();
                    if (first_toPeek == null) {
                        System.out.println("The \"first out\" element doesn't exist (stack is empty)");
                    } else {
                        System.out.println("The \"first out\" element is " + first_toPeek);
                    }
                    break;

                case 4:
                    Object first_toPop = mystack.pop();
                    if (first_toPop == null) {
                        System.out.println("The \"first out\" element doesn't exist (stack is empty)");
                    } else {
                        System.out.println("The \"first out\" element is " + first_toPop);
                        System.out.println("Deleted successfully");
                    }
                    break;

                case 5:
                    System.out.print("Write the integer to add: ");
                    Object Int = input.nextInt(); input.nextLine();
                    mystack.push(Int);
                    break;

                case 6:
                    System.out.print("Write the string to add: ");
                    Object Str = input.nextLine();
                    mystack.push(Str);
                    break;

                case 7:
                    System.out.print("Write the boolean to add: ");
                    Object Bool = input.nextBoolean(); input.nextLine();
                    mystack.push(Bool);
                    break;

                case 8:
                    System.out.print("Write the char to add: ");
                    Object Char = input.next().charAt(0);
                    mystack.push(Char);
                    break;

                case 9:
                    System.out.print("Write the name of influencer: ");
                    String name = input.nextLine();
                    System.out.print("Write the age of influencer: ");
                    int age = input.nextInt(); input.nextLine();
                    Influencer influencer = new Influencer(name, age);
                    mystack.push(influencer);
                    break;

                case 10:
                    System.out.println(mystack);
                    break;

                case 11:
                    mystack.reverse();
                    break;

                case 12:
                    copiedStack = mystack.deepCopy();
                    System.out.println("Copied successfully");
                    break;

                case 13:
                    System.out.println(copiedStack);
                    break;

                case 14:
                    copiedStack.reverse();
                    break;
            
                default:
                    break;
            }
        }

        input.close();
    }
}
