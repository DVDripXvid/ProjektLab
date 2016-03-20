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
        if(isClosed)
            return false;
        else return true;
    }

    /**
     * @return
     */
    @Override
    public boolean enterMovable() {
        // TODO implement here
        if(isClosed)
        return false;
        else return true;
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
        isClosed=false;
        // TODO implement here
    }

    /**
     * 
     */
    public void close() {
        isClosed=true;
        // TODO implement here
    }

}