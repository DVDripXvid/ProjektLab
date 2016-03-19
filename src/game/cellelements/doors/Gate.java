package game.cellelements.doors;

import game.cellelements.doors.Door;
import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public class Gate extends Door {

    /**
     * Default constructor
     */
    public Gate() {
    }
    
    /**
     * 
     * @param movable
     * @return 
     */
    @Override
    public boolean acceptMovable(Movable movable) {
        // TODO implement here
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
        return false;
    }

    /**
     * 
     */
    @Override
    public void exitMovable() {
        // TODO implement here
    }

    /**
     * @return
     */
    @Override
    public CellElement take() {
        // TODO implement here
        return null;
    }


    /**
     * 
     */
    public void open() {
        // TODO implement here
    }

    /**
     * 
     */
    public void close() {
        // TODO implement here
    }

}