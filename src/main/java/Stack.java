import java.util.ArrayList;

public class Stack {
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

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
