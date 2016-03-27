package game.cellelements;

import game.roles.CellElement;
import game.roles.Movable;
import tool.LOGGER;

public class Abyss extends CellElement {

    public Abyss() {
    }

    @Override                                        // a függvény felülírása az aktuális osztályra    
    public boolean acceptMovable(Movable movable) {  //Jelezzük, hogy megérkezett a Movable
        LOGGER.log(this);                            // az esemény loggolása
        movable.destroy();                           // a mozgatható objektum megsemmisítése
        return false;                                // az szakadék nem ZPM
    }

}
