package game.cellelements.doors;

import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;
import tool.LOGGER;

/**
 *
 */
public abstract class Door extends CellElement {

    protected boolean isClosed;//zárva vagy nyitva van

    public Door() {
        isClosed = false;
    }// Default constructor

    @Override
    public boolean acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        LOGGER.log(this);
        return false;
    }

    public boolean isClosed() {//lekérdezzük, hogy zárva van-e
        LOGGER.log(this);
        return isClosed;
    }

    @Override
    public boolean obstacleForProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek
        LOGGER.log(this);
        return false;
    }

    @Override
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable
        LOGGER.log(this);
        return false;
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

}
