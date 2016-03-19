package game.cellelements;

import game.map.Quarter;


/**
 * 
 */
public class Floor extends Abyss{

    /**
     * Default constructor
     */
    public Floor() {
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