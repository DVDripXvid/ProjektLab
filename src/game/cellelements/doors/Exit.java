package game.cellelements.doors;

import game.cellelements.doors.Door;
import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;
import tool.LOGGER;

public class Exit extends Door {

    public Exit() {

    }

    @Override
    public boolean acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable így vége a játéknak
        LOGGER.log(this);
        return false;
    }

    @Override
    public boolean obstacleForProjectile(Quarter quarter) {
        LOGGER.log(this);
        return false;
    }//Lekérdezzük, hogy akadály-e a lövedéknek

    @Override
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable
        LOGGER.log(this);
        return !isClosed;

    }

    public void open() {//kinyitjuk az ajtót
        LOGGER.log(this);
        isClosed = false;
    }

}
