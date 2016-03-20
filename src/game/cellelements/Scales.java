package game.cellelements;


import game.cellelements.doors.Gate;
import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public class Scales extends CellElement{
protected Gate myGate;

    /**
     * @param gate
     */
    public Scales(Gate gate) {
        myGate=gate;

    }

    /**
     * 
     * @param movable
     * @return 
     */
    @Override
    public boolean acceptMovable(Movable movable) {

        myGate.open();
        return false;
    }

    @Override
    public void exitMovable() {
        myGate.close();
        // TODO implement here
    }

}