package graphics.uielement;

<<<<<<< HEAD
import game.cellelements.doors.Exit;
import graphics.ImageHandler;
=======
>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
import graphics.UiElement;

/**
 * Created by Olivér on 2016.05.11..
 */
public class UiExit extends UiElement {
<<<<<<< HEAD

    private Exit exit;

    public UiExit(Exit exit) {

        image = ImageHandler.getImage("src/graphics/img/gate_closed.jpg");
        this.exit = exit;

    }

    public void update() {
        if (exit.isClosed()) {
            image = ImageHandler.getImage("src/graphics/img/gate_closed.jpg");
        } else {
            image = ImageHandler.getImage("src/graphics/img/gate_open.jpg");
        }
    }
=======
>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
}
