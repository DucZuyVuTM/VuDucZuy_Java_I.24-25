import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackOnQueue {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    // Constructor
    public StackOnQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push element onto the top of the stack
    public void push(int x) {
        // Move all elements from q1 to q2
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        
        // Swap queues q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Remove the element at the top of the stack and return it
    public int pop() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.poll();
    }

    // Return the element on the top of the stack
    public int top() {
        if (q1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return q1.peek();
    }

    // Returns true if the stack is empty, false otherwise
    public boolean empty() {
        return q1.isEmpty();
    }

    // Method to display all elements of a stack
    public String display() {
        String output = "";
        LinkedList<Integer> q3 = (LinkedList<Integer>) q1;

        for (int i = q1.size() - 1; i >= 0; i--) {
            output += ((q3.get(i)) + " ");
        }

        return output.trim();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StackOnQueue stack = new StackOnQueue();

        System.out.println("Menu:");
        System.out.println("1) Push new element into the stack.");
        System.out.println("2) Print the \"last in\" element and delete it from stack.");
        System.out.println("3) Print the \"last in\" element of the stack.");
        System.out.println("4) Check if the stack is empty.");
        System.out.println("5) Display all the elements in stack.");
        System.out.println("0) EXIT");

        int choice = 6;
        int i = 0;
        String result = "";
        while (choice != 0) {
            System.out.print("Your choice: ");
            choice = input.nextInt(); input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Write the integer: ");
                    i = input.nextInt(); input.nextLine();
                    stack.push(i);
                    break;

                case 2:
                    System.out.println("The \"last in\" element is: " + stack.pop());
                    System.out.println("Deleted successfully");
                    break;

                case 3:
                    System.out.println("The \"last in\" element is: " + stack.top());
                    break;

                case 4:
                    if (stack.empty()) {
                        System.out.println("The stack is empty");
                    } else {
                        System.out.println("The stack is not empty");
                    }
                    break;

                case 5:
                    result = stack.display();
                    if (result == "") {
                        result = "<empty>";
                    }
                    System.out.println("Stack: " + result);
                    break;
            
                default:
                    break;
            }
        }

        input.close();
    }
}