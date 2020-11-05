import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {

            System.out.println("Введите путь к папке, которую необходимо скопировать:");
            File fromFolder = new File(scanner.nextLine());

            System.out.println("Укажите путь куда необходимо скопировать:");
            String toFolder = scanner.nextLine();

            copyFiles(fromFolder, toFolder);
        }
    }


    public static void copyFiles(File fromDirectory, String toFolder) {

        String toNewFolder = toFolder + "\\" + fromDirectory.getName();

        try {
            if (fromDirectory.isDirectory()) {
                Path from = Paths.get(fromDirectory.getAbsolutePath());
                Path to = Paths.get(toNewFolder);
                Files.copy(from, to, REPLACE_EXISTING);

                File[] files = fromDirectory.listFiles();

                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile()) {
                        String toNewFile = toNewFolder + "\\" + files[i].getName();
                        Files.copy(Path.of(files[i].getAbsolutePath()), Path.of(toNewFile));
                    } else if (files[i].isDirectory()) {
                        copyFiles(files[i], toNewFolder);
                    }
                }

            } else if (fromDirectory.isFile()) {
                Path from = Paths.get(fromDirectory.getAbsolutePath());
                Path to = Paths.get(toNewFolder);
                Files.copy(from, to, REPLACE_EXISTING);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
