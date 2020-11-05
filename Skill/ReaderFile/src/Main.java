import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static double KBAYT = 1024;
    private static double MBAYT = 1024 * KBAYT;
    private static double GBAYT = 1024 * MBAYT;
    private static double TBAYT = 1024 * GBAYT;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            System.out.println("Введите путь к папке:");
            String directory = scanner.nextLine();
            File folder = new File(directory);
            if (folder.isDirectory()) {
                System.out.println(measureUnit(weightFolder(folder)));
            } else if (folder.isFile()) {
                System.out.println(measureUnit(folder.length()));
            } else {
                System.out.println("Введен некорректный путь");
            }

        }

    }

    public static Long weightFolder(File folder) {
        long lengthFolder = 0;
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                lengthFolder += files[i].length();
            } else {
                lengthFolder += weightFolder(files[i]);
            }
        }
        return lengthFolder;
    }

    public static String measureUnit(Long lengthFolder) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        String unit = "Размер папки/файла ";
        if (lengthFolder <= MBAYT) {
            unit += formatter.format(lengthFolder / KBAYT) + " КБ";
        } else if (lengthFolder <= GBAYT) {
            unit += formatter.format(lengthFolder / MBAYT) + " МБ";
        } else if (lengthFolder <= TBAYT) {
            unit += formatter.format(lengthFolder / GBAYT) + " ГБ";
        } else if (lengthFolder >= TBAYT) {
            unit += formatter.format(lengthFolder / TBAYT) + " ТБ";
        }
        return unit;
    }
}
