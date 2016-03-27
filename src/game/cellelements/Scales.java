package game.cellelements;

import game.cellelements.doors.Gate;
import game.roles.CellElement;
import game.roles.Movable;
import tool.LOGGER;

public class Scales extends CellElement {

    protected Gate myGate;

    public Scales(Gate gate) {
        myGate = gate;                // összekötjük a mérleget az ajtajával
    }

    @Override                       // a függvény felülírása az aktuális osztályra 
    public boolean acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        LOGGER.log(this);
        myGate.open();              // ráléptek, kinyílik az ajtó
        return false;               // a mérleg nem ZPM
    }

    @Override                       // a függvény felülírása az aktuális osztályra 
    public void exitMovable() {
        LOGGER.log(this);
        myGate.close();             // elléptek róla, bezárul az ajtó
    }

}
