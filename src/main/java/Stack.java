import java.util.ArrayList;
import java.util.List;

public class StackCalculator {
    private final ArrayList<String> stack = new ArrayList<>();

    public void push(String element) {
        stack.add(0, element);
    }

    public String pop() {
        return stack.remove(0);
    }

    public String peek() {
        return stack.get(0);
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public int search(String element) {
        return stack.indexOf(element);
    }
}
