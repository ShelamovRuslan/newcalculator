import java.util.ArrayList;

public class Calculator {

   private double result;
   private final ArrayList<String> inverseNotation;
   private final Stack stack;

   private double firstNumber;
   private double secondNumber;


   public Calculator (ArrayList<String> inverseNotation){
       this.inverseNotation = inverseNotation;
       this.stack = new Stack();
       calc();
   }

    public double getResult() {
        return result;
    }

    private void calc() {
       for (String element: this.inverseNotation){
            switch (element) {
                case "*":
                   popNumbersFromStack();
                   this.stack.push(String.valueOf(this.firstNumber * this.secondNumber));
                   break;
                case "/":
                    popNumbersFromStack();
                    this.stack.push(String.valueOf(this.secondNumber / this.firstNumber));
                    break;
                case "+":
                    popNumbersFromStack();
                    this.stack.push(String.valueOf(this.firstNumber + this.secondNumber));
                    break;
                case "-":
                    popNumbersFromStack();
                    this.stack.push(String.valueOf(this.secondNumber - this.firstNumber));
                    break;
                default:
                    this.stack.push(element);
            }
       }
       this.result = Double.parseDouble(this.stack.pop());
   }

   private void popNumbersFromStack() {
       this.firstNumber = Double.parseDouble(stack.pop());
       this.secondNumber = Double.parseDouble(stack.pop());
   }

}
