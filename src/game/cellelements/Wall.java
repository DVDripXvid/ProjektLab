package game.cellelements;

import game.map.Quarter;
import game.roles.CellElement;

/**
 * 
 */
public class Wall extends CellElement{

    /**
     * Default constructor
     */
    public Wall() {
    }
    
        @Override
    public boolean enterMovable() {
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
        return true;
    }


}