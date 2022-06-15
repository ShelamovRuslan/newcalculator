import java.util.ArrayList;

import static java.lang.Character.isDigit;

public class Distributor {

   private int counter;
   private ArrayList<String> inverseNotation;
   private Stack stack;


    public Distributor(ArrayList<String> elements) {
        this.counter = 0;
        this.inverseNotation = new ArrayList<>();
        this.stack = new Stack();
        for (String element : elements) {
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
                stack.push(element);
            } else if (element.equals("*") || element.equals("/")) {
                if (stack.peek().equals("+") || stack.peek().equals("-")) {
                    stack.push(element);
                } else if (stack.peek().equals("*") || stack.peek().equals("/")) {
                    while (stack.peek().equals("*") || stack.peek().equals("/")){
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
