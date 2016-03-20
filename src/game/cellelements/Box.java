package game.cellelements;

import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public class Box extends CellElement implements Movable{

    /**
     * Default constructor
     */
    public Box() {
    }

    /**
     * @return
     */
    @Override
    public CellElement take() {

        return this;
    }
    
    /**
     * @return
     */
    @Override
    public boolean enterMovable() {

        return false;
    }
    
    /**
     * @param quarter
     * @return
     */
    @Override
    public boolean obstacleForProjectile(Quarter quarter) {

        return true;
    }

}