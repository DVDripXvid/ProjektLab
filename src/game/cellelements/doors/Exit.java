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
        LOGGER.gameSuccess();
        return false;
    }


    @Override
    public boolean obstacleForProjectile(Quarter quarter) {
        return false;
    }//Lekérdezzük, hogy akadály-e a lövedéknek


    @Override
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable

return !isClosed;

    }
    public void open() {//kinyitjuk az ajtót

        isClosed=false;
        LOGGER.doorStatus(this);

    }



}