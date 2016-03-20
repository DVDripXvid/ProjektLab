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