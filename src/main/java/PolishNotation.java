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
            switch (element) {
                case "(" -> bracketOpen(element);
                case ")" ->  bracketClose();
                case "+", "-" ->  plus (element);
                case "*", "/" -> multiplication(element);
                default -> inverseNotation.add(element);
            }
        }

        while (!stack.isEmpty()){
            inverseNotation.add(stack.pop());
        }
   }

   private void bracketOpen (String element) {
           stack.push(element);
   }
    private void bracketClose () {
            while (!stack.peek().equals("(")) {
                inverseNotation.add(stack.pop());
            }
            if (stack.peek().equals("(")) {
                stack.pop();
            }
    }
    private void plus (String element) {
            if (!stack.isEmpty()) {
                while (stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("+") || stack.peek().equals("-")) {
                    inverseNotation.add(stack.pop());
                    if (stack.isEmpty()){
                        break;
                    }
                }
            }
            stack.push(element);
    }
    private void multiplication (String element) {
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
    }
}

