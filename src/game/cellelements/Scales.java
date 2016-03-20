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
     * Default constructor
     */
    public Scales() {
    }

    /**
     * @param gate
     */
    public Scales(Gate gate) {
        myGate=gate;
        // TODO implement here
    }

    /**
     * 
     * @param movable
     * @return 
     */
    @Override
    public boolean acceptMovable(Movable movable) {
        // TODO implement here
        myGate.open();
        return false;
    }

    /**
     * @param quarter
     * @return
     */
    @Override
    public boolean obstacleForProjectile(Quarter quarter) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean enterMovable() {
        // TODO implement here

        return true;
    }

    /**
     * 
     */
    @Override
    public void exitMovable() {
        myGate.close();
        // TODO implement here
    }

}