package game.roles;

import game.map.Quarter;
import tool.LOGGER;

/**
 * 
 */
public abstract class CellElement {

    /**
     * Default constructor
     */
    public CellElement() {
    }


    /**
     * @param movable 
     * @return
     */
    public boolean acceptMovable(Movable movable) {
        LOGGER.enterCell(this);
        // TODO implement here
        return false;
    }

    /**
     * @param quarter
     * @return
     */
    public boolean obstacleForProjectile(Quarter quarter) {
        LOGGER.meetProjectile(this);
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean enterMovable() {
        LOGGER.askCell(this);
        // TODO implement here
        return true;
    }

    /**
     * 
     */
    public void exitMovable() {
        LOGGER.leaveCell(this);
        // TODO implement here
    }

    /**
     * @return
     */
    public CellElement take() {
        // TODO implement here
        return null;
    }
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }

}