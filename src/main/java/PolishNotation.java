import java.util.ArrayList;

import static java.lang.Character.isDigit;

public class PolishNotation {

   private final ArrayList<String> inverseNotation;
   private final Stack stack;

    public ArrayList<String> getInverseNotation() {
        return inverseNotation;
    }
    public PolishNotation(ArrayList<String> elementsExpression) {
        this.inverseNotation = new ArrayList<>();
        this.stack = new Stack();
        for (String element : elementsExpression) {
            if (element.equals("(")) {
                stack.push(element);
            } else if (element.equals(")")) {
                while (!stack.peek().equals("(")) {
                    inverseNotation.add(stack.pop());
                }
                if (stack.peek().equals("(")) {
                    stack.pop();
                }
            } else if (element.equals("+") || element.equals("-")) {
                if (!stack.isEmpty()) {
                    while (stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("+") || stack.peek().equals("-")) {
                        inverseNotation.add(stack.pop());
                        if (stack.isEmpty()){
                            break;
                        }
                    }
                }
                stack.push(element);
            } else if (element.equals("*") || element.equals("/")) {
                if (stack.peek().equals("+") || stack.peek().equals("-")) {
                    stack.push(element);
                } else if (stack.peek().equals("*") || stack.peek().equals("/")) {

                        while (stack.peek().equals("*") || stack.peek().equals("/")) {
                            inverseNotation.add(stack.pop());
                        }

                    stack.push(element);
                } else if (stack.peek().equals("(")) {
                    stack.push(element);
                }
            } else {
                inverseNotation.add(element);
            }
        }
        while (!stack.isEmpty()){
            inverseNotation.add(stack.pop());
        }
   }
}
