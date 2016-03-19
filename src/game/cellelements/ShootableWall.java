package game.cellelements;


import game.map.Cell;
import game.map.Quarter;
import javafx.util.Pair;

/**
 * 
 */
public class ShootableWall extends Wall {

    /**
     * Default constructor
     */
    public ShootableWall() {
    }

    /**
     * 
     */
    private static Pair <Cell, Quarter> bluePortal;

    /**
     * 
     */
    private static Pair <Cell, Quarter> yellowPortal;


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