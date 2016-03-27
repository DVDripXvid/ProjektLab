package game.cellelements;

import game.cellelements.doors.Exit;
import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;
import tool.LOGGER;

/**
 *
 */
public class ZPM extends CellElement {

    static Exit exit;//kilépő kapu

    public ZPM() {//konstruktor
    }

    public static int count;//hány darab zpm van még

    @Override
    public boolean acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        LOGGER.log(this);
        count--;
        //  if(count ==0) Exit.open();
        return true;
    }

}
