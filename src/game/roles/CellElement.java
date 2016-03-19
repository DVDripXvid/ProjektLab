package game.roles;

import game.map.Quarter;

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
        // TODO implement here
        return false;
    }

    /**
     * @param quarter
     * @return
     */
    public boolean obstacleForProjectile(Quarter quarter) {
        // TODO implement here
        return true;
    }

    /**
     * @return
     */
    public boolean enterMovable() {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void exitMovable() {
        // TODO implement here
    }

    /**
     * @return
     */
    public CellElement take() {
        // TODO implement here
        return null;
    }

}