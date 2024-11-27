import java.lang.Thread;

public class Test {
    public static void main(String[] args) {
        try {
            System.out.println("Test for the class StackOnQueue.");

            System.out.println("Creating object...");
            Thread.sleep(1500);
            StackOnQueue stack = new StackOnQueue();
            System.out.println("-----");

            System.out.println("Test: Adding element...");
            Thread.sleep(3000);
            stack.push(3);
            stack.push(6);
            System.out.println("-----");

            System.out.println("Test: Printing object on top...");
            Thread.sleep(3000);
            System.out.println("Object on top: " + stack.top());
            System.out.println("-----");

            System.out.println("Test: Printing object on top and deleting it...");
            Thread.sleep(3000);
            System.out.println("Object on top: " + stack.pop());
            System.out.println("Deleted");
            System.out.println("-----");

            System.out.println("Test: Checking if the stack is empty...");
            Thread.sleep(3000);
            if (stack.empty()) {
                System.out.println("The stack is empty");
            } else {
                System.out.println("The stack is not empty");
            }
            System.out.println("-----");

            System.out.println("Test: Displaying all the elements in stack...");
            Thread.sleep(3000);
            String result = stack.display();
            if (result == "") {
                result = "<empty>";
            }
            System.out.println("Stack: " + result);
            System.out.println("-----");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}