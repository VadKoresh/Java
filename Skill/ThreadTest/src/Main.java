import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Main {

    private static final int newWidth = 300;

    public static void main(String[] args) {

        int processorsCount = Runtime.getRuntime().availableProcessors();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь папки с картинками:");
        String srcFolder = scanner.nextLine();
        System.out.println("Введите путь к папки, куда все скопировать:");
        String dstFolder = scanner.nextLine();

        File srcDir = new File(srcFolder);

        File[] files = srcDir.listFiles();
        int middle = files.length / processorsCount;
        int startCopy = 0;


        for (int i = 0; i < processorsCount; i++){
            File[] files1 = new File[middle];
            System.arraycopy(files,startCopy, files1, 0, files1.length);
            ImageResizer imageResizer = new ImageResizer(files1, dstFolder, newWidth);
            imageResizer.start();
            startCopy += middle;
             if (i + 1 == processorsCount){
                 middle = files.length - middle * i;
             }
        }
    }
}
