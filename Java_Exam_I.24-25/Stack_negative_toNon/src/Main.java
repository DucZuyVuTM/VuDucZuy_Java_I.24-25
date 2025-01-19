import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void splitStack(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<Integer>();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int current = queue.poll();
            if (current < 0) {
                stack.push(current);
            } else {
                queue.offer(current);
            }
        }

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(3);
        stack.push(-2);
        stack.push(1);
        stack.push(8);
        stack.push(-4);
        stack.push(0);

        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();

        splitStack(stack);

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}