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
        LOGGER.log(this);
        return false;
    }

    /**
     * @param quarter
     * @return
     */
    public boolean obstacleForProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek
        LOGGER.log(this);
        return false;
    }

    /**
     * @return
     */
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable
        LOGGER.log(this);
        return true;
    }

    /**
     *
     */
    public void exitMovable() {//Jelezzük, hogy elment a Movable
        LOGGER.log(this);
    }

    /**
     * @return
     */
    public CellElement take() {
        LOGGER.log(this);
        return null;
    }//A doboz felvételéhez szükséges függvény

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
