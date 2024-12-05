import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> history = new Stack<>();

    public void save(Memento memento) {
        if (history.isEmpty() || history.peek().getState() != memento.getState()) {
            history.push(memento);
        }
    }

    public Memento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
