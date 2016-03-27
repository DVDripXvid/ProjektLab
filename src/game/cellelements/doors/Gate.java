package game.cellelements.doors;

import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;
import tool.LOGGER;

/**
 *
 */
public class Gate extends Door {

    public Gate() { //Default constructor
    }

    @Override
    public boolean acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        LOGGER.log(this);
        return false;
    }

    @Override
    public boolean obstacleForProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek
        LOGGER.log(this);
        if (isClosed) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable
        LOGGER.log(this);
        if (isClosed) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void exitMovable() {//Jelezzük, hogy elment a Movable
        LOGGER.log(this);
    }

    @Override
    public CellElement take() {//doboz felvevésnél játszik szerepet, itt nem
        LOGGER.log(this);
        return null;
    }

    /**
     *
     */
    public void open() {
        LOGGER.log(this);
        isClosed = false;
    }

    /**
     *
     */
    public void close() {
        LOGGER.log(this);
        isClosed = true;
    }

}
