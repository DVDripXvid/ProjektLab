package game.cellelements;


import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public class ZPM extends CellElement{

    /**
     * Default constructor
     */
    public ZPM() {
    }

    /**
     * 
     */
    public static int count;

    /**
     * 
     * @param movable
     * @return 
     */
    @Override
    public boolean acceptMovable(Movable movable) {
        // TODO implement here
        return true;
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

}