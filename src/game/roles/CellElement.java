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

        return false;
    }

    /**
     * @param quarter
     * @return
     */
    public boolean obstacleForProjectile(Quarter quarter) {
        LOGGER.meetProjectile(this);

        return false;
    }

    /**
     * @return
     */
    public boolean enterMovable() {
        LOGGER.askCell(this);

        return true;
    }

    /**
     * 
     */
    public void exitMovable() {
        LOGGER.leaveCell(this);

    }

    /**
     * @return
     */
    public CellElement take() {
        return null;
    }
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }

}