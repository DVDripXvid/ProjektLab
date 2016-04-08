package game.cellelements;

import game.cellelements.doors.Exit;
import game.roles.CellElement;
import game.roles.Movable;

/**
 *
 */
public class ZPM extends CellElement {

    static Exit EXIT;//kilépő kapu

    public static int count;//hány darab zpm van még
    
    public ZPM() {//konstruktor
        ++count;
    }
    
    public static void setEXIT(Exit exit){
        EXIT = exit;
    }

    @Override
    public void acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        movable.meetWith(this);
    }
    
    public void destroy(){
        --count;
        if(count <= 0) EXIT.open();
    }

}
