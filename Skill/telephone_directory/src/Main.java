import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {

    public static final int NUMBER_LENGTH = 10;
    public static TreeMap<String, String> phoneAndName = new TreeMap<>();


    public static void main(String[] args) {
        phoneAndName.put("+7 999 970-92-26", "Вадим");

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.println("Введите команду:");
            String scannerNameOrPhone = scanner.nextLine();
            if (scannerNameOrPhone.equalsIgnoreCase("list")) {
                allName();
                System.out.println("============================================");
                continue;
            }

            if (Character.isLetter(scannerNameOrPhone
                .charAt(0))) {            //Определяем ввели ли номер телефона или ФИО
                if (findName(scannerNameOrPhone)) {     //есть ли значение БЕЗ УЧЕТА РЕГИСТРА
                    printName(scannerNameOrPhone);
                    continue;
                } else {
                    System.out.println(
                        "Данное имя не найдено. Если хотите добавить новое конткт введите номер телефона."
                            +
                            "\nЕсли хотите начать новый поиск напишите \"Поиск\"");
                    Scanner scannerNewOrFind = new Scanner(System.in);
                    String newOrFind = scannerNewOrFind.nextLine();
                    if (newOrFind.equalsIgnoreCase("Поиск")) {
                        continue;
                    } else {
                        newContact(newOrFind, scannerNameOrPhone);
                        continue;
                    }
                }
            }

            if (phoneAndName.containsKey(
                phone(scannerNameOrPhone)))            //проверяем если такой номер в справочнике
            {
                System.out.println(phone(scannerNameOrPhone) + " --> " + phoneAndName
                    .get(phone(scannerNameOrPhone)));
            } else {
                System.out.println(
                    "Данный номер не найдено. Если хотите добавить новое контакт введите номер телефона."
                        +
                        "\nЕсли хотите начать новый поиск напишите \"Поиск\"");
                Scanner scannerNewOrFind = new Scanner(System.in);
                String newOrFind = scannerNewOrFind.nextLine();
                if (newOrFind.equalsIgnoreCase("Поиск")) {
                    continue;
                } else {
                    newContact(scannerNameOrPhone, newOrFind);
                    continue;
                }
            }

        }
    }

    public static boolean findName(String scannerNameOrPhone) {         //ищем имя
        for (String key : phoneAndName.keySet()) {
            if (phoneAndName.get(key).equalsIgnoreCase(scannerNameOrPhone)) {
                return true;
            }
        }
        return false;

    }

    private static void allName() {
        for (String key : phoneAndName.keySet()) {
            System.out.println(key + " --> " + phoneAndName.get(key));
        }
    }

    private static void printName(String scannerNameOrPhone) {  //печатаем нужное нам имя
        for (String key : phoneAndName.keySet()) {
            if (phoneAndName.get(key).equalsIgnoreCase(scannerNameOrPhone)) {
                System.out.println(key + " --> " + phoneAndName.get(key));
            }
        }
    }

    private static String phone(String scannerNameOrPhone) {
        String number = scannerNameOrPhone.replaceAll("[^0-9]", ""); //форматируем номер телефона
        if (Character.isDigit(number.charAt(0)) && number.length() == NUMBER_LENGTH) {
            Pattern.compile("([0-9]{3})([0-9]{3})([0-9]{2})([0-9]{2})");
            String formatNumber = number
                .replaceAll("(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+7 $1 $2-$3-$4");
            number = formatNumber;
        } else if (Character.isDigit(number.charAt(0)) && number.length() != NUMBER_LENGTH) {
            Pattern.compile("([0-9]{1})([0-9]{3})([0-9]{3})([0-9]{2})([0-9]{2})");
            String formatNumber = number
                .replaceAll("(\\d)(\\d{3})(\\d{3})(\\d{2})(\\d{2})", "+7 $2 $3-$4-$5");
            number = formatNumber;
        }
        return number;
    }

    private static void newContact(String newOrFind, String scannerNameOrPhone) {
        phoneAndName.put(phone(newOrFind), scannerNameOrPhone);
        System.out.println("============================================");
    }

}
