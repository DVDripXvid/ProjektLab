package game.cellelements.doors;


import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public abstract class Door extends CellElement{
protected boolean isClosed;
    /**
     * Default constructor
     */
    public Door() {
        isClosed=false;
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
public boolean isClosed(){

    return isClosed;
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
        return false;
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

}