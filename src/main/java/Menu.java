import java.util.ArrayList;

public class Menu {

    public void run() {
        System.out.println("Калькулятор\nВсе записанные выражения\n" +
                "Изменение выражения\nНайти выражения\nНайти все выражения со значениями больше введенного" +
                "\nНайти все выражения со значениями меньше введенного\nЗакрыть");

        String command = Console.in("Что сделать?");

        switch(command) {
            case "Калькулятор":
                ArrayList<String> list = new ArrayList<>();
                try {
                    list = Debugger.core(Console.in("Введите арифметичное выражение."));
                } catch (Error e) {
                    System.out.println("Ошибка");
                }
                PolishNotation distributor = new PolishNotation(list);
                Calculator calculator = new Calculator(distributor.getInverseNotation());
                System.out.println(calculator.getResult());
                break;
            case "Все записанные выражения":

                break;
            case "Изменение выражения":

                break;
            case "Найти выражения":

                break;
            case "Найти все выражения со значениями больше введенного":

                break;
            case "Найти все выражения со значениями меньше введенного":

                break;
            case "Закрыть":
                break;

        }
    }
}



