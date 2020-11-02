import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final int PASSWORD = 1314; //для основного цикла

    public static void main(String[] args) {
        ArrayList<String> listCase = new ArrayList<>();
        listCase.add("Пойти за хлебом");
        listCase.add("Пойти на тренировку!");

        while (PASSWORD != 0) {
            System.out
                .println("Введите команду: \nList\nAdd название_дела (дело добавится в конец)" +
                    "\nAdd n_назнавание_дела (где n - какое место дело будет установлено)\n" +
                    "Edit n_новое_название_дела\nDelete n (удалить дело № n)");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            String[] commandSplit = command.split("\\s+");

            System.out.println("======================================\n");

            if (commandSplit[0].equalsIgnoreCase("list")) {               //команда list
                System.out.println("Список Ваших дел:");
                for (int i = 0; i < listCase.size(); i++) {
                    System.out.println(
                        i + 1 + " " + listCase.get(i));           //i+1 чтобы список начинался с 1
                }

                System.out.println("======================================\n");
            } else if (commandSplit[0].equalsIgnoreCase("add")) {            //команда add
                if (Character.isDigit(commandSplit[1]
                    .charAt(0))) {                        //проверяем есть ли тут какое то число
                    int positionNumber = Integer.parseInt(commandSplit[1]);
                    String activity = command.replaceAll("[0-9]", ""); //избавляемся от чисел
                    activity = activity.substring(command.indexOf(" ") + 1).trim();
                    listCase.add(positionNumber - 1, activity);
                } else {
                    listCase.add(command.substring(command.indexOf(" ") + 1));
                }
            } else if (commandSplit[0].equalsIgnoreCase("edit")) {           //команда edit
                if (Character.isDigit(
                    commandSplit[1].charAt(0))) {         //проверяем есть ли тут какое то число
                    int positionNumber = Integer.parseInt(commandSplit[1]);
                    String activity = command.replaceAll("[0-9]", ""); //избавляемся от чисел
                    activity = activity.substring(command.indexOf(" ") + 1).trim();
                    listCase.set(positionNumber - 1, activity);
                } else {
                    System.out
                        .println("Ошибка! Вы не ввели номер дела которое хотите отредактировать!");
                    System.out.println("======================================\n");
                }

            } else if (commandSplit[0].equalsIgnoreCase("delete")) {        //команда delete
                if (commandSplit.length >= 2 && Character.isDigit(commandSplit[1]
                    .charAt(0))) {                        //проверяем есть ли тут какое то число
                    int positionNumber = Integer.parseInt(commandSplit[1]);
                    listCase.remove(positionNumber - 1);
                } else {
                    System.out.println("Ошибка! Введите номер дела который хотите удалить");
                    System.out.println("======================================\n");
                }

            }
        }
    }
}

