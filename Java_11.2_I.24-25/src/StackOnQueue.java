import java.util.LinkedList;
import java.util.Queue;

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
}