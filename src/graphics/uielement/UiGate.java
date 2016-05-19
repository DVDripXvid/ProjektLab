package graphics.uielement;

<<<<<<< HEAD
import game.cellelements.doors.Gate;
import graphics.ImageHandler;
=======
>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
import graphics.UiElement;

/**
 * Created by Olivér on 2016.05.11..
 */
public class UiGate extends UiElement {
<<<<<<< HEAD

    private Gate gate;

    public UiGate(Gate gate) {
        image = ImageHandler.getImage("src/graphics/img/gate_closed.jpg");
        this.gate = gate;
    }

    public void update() {
        if (gate.isClosed()) {
            image = ImageHandler.getImage("src/graphics/img/gate_closed.jpg");
        } else {
            image = ImageHandler.getImage("src/graphics/img/gate_open.jpg");
        }
    }
=======
>>>>>>> 711f6bff60e45588e2677dd86c802175f9aff5e0
}
