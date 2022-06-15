import java.util.Scanner;

public class Console {
    public static Scanner scanner = new Scanner(System.in);
    public static String in (String massage) {

        while (true) {
            System.out.println(massage);
            String command = scanner.nextLine();
            if (command.equals("")) {
                System.out.println("Вы ничего не ввели, попробуйте еще раз!");
            } else {
                return command;
            }
        }
    }
}