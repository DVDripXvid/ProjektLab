package game.roles;

import game.map.Quarter;
import tool.LOGGER;

/**
 * 
 */
public abstract class CellElement {



    public CellElement() {   //    Default constructor
    }


    /**
     * @param movable 
     * @return
     */
    public boolean acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        LOGGER.enterCell(this);

        return false;
    }

    /**
     * @param quarter
     * @return
     */
    public boolean obstacleForProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek
        LOGGER.meetProjectile(this);

        return false;
    }

    /**
     * @return
     */
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable
        LOGGER.askCell(this);

        return true;
    }

    /**
     * 
     */
    public void exitMovable() {//Jelezzük, hogy elment a Movable
        LOGGER.leaveCell(this);

    }

    /**
     * @return
     */
    public CellElement take() {
        return null;
    }//A doboz felvételéhez szükséges függvény
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }

}