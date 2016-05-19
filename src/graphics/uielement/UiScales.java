package graphics.uielement;

<<<<<<< HEAD
import game.cellelements.Scales;
import graphics.UiElement;

import java.io.File;

=======
import graphics.UiElement;

>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
/**
 * Created by Olivér on 2016.05.11..
 */
public class UiScales extends UiElement {
<<<<<<< HEAD

    public UiScales(Scales scales) {

        try {
            image = javax.imageio.ImageIO.read(new File("src/graphics/img/scales.jpg"));
            label = Integer.toString(scales.getLimit());
        } catch (Exception e) {
            System.out.println("Error: no scales image found at 'src/graphics/img/scales.jpg'.");
        }
    }

=======
>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
}
