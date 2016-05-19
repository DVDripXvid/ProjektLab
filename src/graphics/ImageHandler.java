package graphics;

import java.awt.*;
import java.io.File;
import java.util.HashMap;

/**
 * Created by Ádám on 16/05/2016.
 */
public class ImageHandler {

    static HashMap<String, Image> imageMap = new HashMap<>();

    public static Image getImage(String path) {
        Image image;
        image = imageMap.get(path);
        if (image != null)
            return image;
        else {
            try {
                image = javax.imageio.ImageIO.read(new File(path));
                imageMap.put(path, image);
            } catch (Exception e) {
                System.out.println("Error at getting image from " + path);
            }
        }
        return image;
    }


}
