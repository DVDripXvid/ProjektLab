package game.cellelements;

import game.map.Quarter;
import game.roles.CellElement;
import tool.LOGGER;

public class Wall extends CellElement {

    public Wall() {//Default constructor
    }

    @Override
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable
        LOGGER.log(this);
        return false;
    }

    @Override
    public boolean obstacleForProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek
        LOGGER.log(this);
        return true;
    }

}
