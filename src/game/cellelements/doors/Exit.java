package game.cellelements.doors;

import game.cellelements.doors.Door;
import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;
import tool.LOGGER;


/**
 * 
 */
public class Exit extends Door {


    public Exit() {

    }

    /**
     * 
     * @param movable
     * @return 
     */
    @Override
    public boolean acceptMovable(Movable movable) {
        LOGGER.gameSuccess();
        return false;
    }

    /**
     * @param quarter
     * @return
     */
    @Override
    public boolean obstacleForProjectile(Quarter quarter) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean enterMovable() {

return !isClosed;

    }
    public void open() {

        isClosed=false;
        LOGGER.doorStatus(this);
        // TODO implement here
    }



}