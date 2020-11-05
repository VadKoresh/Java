import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

public class ImageResizer extends Thread{

    private File[] files;
    private String dstFolder;
    private int newWidth;

    public ImageResizer(File[] files, String dstFolder, int newWidth){
        this.files = files;
        this.dstFolder = dstFolder;
        this.newWidth = newWidth;
    }
    
    @Override
    public void run() {

        try
        {
            for(File file : files)
            {
                BufferedImage image = ImageIO.read(file);
                if(image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(
                    image.getHeight() / (image.getWidth() / (double) newWidth)
                );

                BufferedImage newImage = Scalr.resize(image, newWidth, newHeight);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
