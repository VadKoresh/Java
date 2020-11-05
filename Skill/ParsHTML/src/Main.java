import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

    public static final String URL_LENTA = "https://lenta.ru";

    public static void main(String[] args) {
        File folder = new File("images");
        folder.mkdir();
        try {
           Document document = Jsoup.connect(URL_LENTA).get();
           Elements elements = document.select("img");
           elements.forEach(element -> {
               String absSrc = element.attr("abs:src");
               System.out.println(getNameFiles(absSrc));
               getPictures(absSrc ,getNameFiles(absSrc));
           });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String getNameFiles(String elementSrc){
        elementSrc = elementSrc.substring(elementSrc.lastIndexOf("/")+1);
        if (elementSrc.substring(elementSrc.indexOf('.')+1).length() > 3){
            elementSrc = elementSrc.substring(0, elementSrc.indexOf('.') + 4);
        }
        return elementSrc;
    }

    public static void getPictures(String urmPicture, String namePicture){
        try {
            InputStream in = new URL(urmPicture).openStream();
            Files.copy(in, Paths.get("images/" + namePicture));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
