package game.cellelements.doors;

import game.cellelements.doors.Door;
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
               return false;
    }


    @Override
    public boolean obstacleForProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek
        if(isClosed)
            return false;
        else return true;
    }

    @Override
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable
        if(isClosed)
        return false;
        else return true;
    }


    @Override
    public void exitMovable() {//Jelezzük, hogy elment a Movable

    }

    @Override
    public CellElement take() {//doboz felvevésnél játszik szerepet, itt nem

        return null;
    }


    /**
     * 
     */
    public void open() {

        isClosed=false;
        LOGGER.doorStatus(this);
        // TODO implement here
    }

    /**
     * 
     */
    public void close() {
        isClosed=true;
        LOGGER.doorStatus(this);
        // TODO implement here
    }

}