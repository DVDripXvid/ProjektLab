package game.cellelements;

import game.map.Quarter;
import game.roles.CellElement;


public class Wall extends CellElement{



    public Wall() {//Default constructor
    }
    
        @Override
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable

        return false;
    }
    

    @Override
    public boolean obstacleForProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek

        return true;
    }


}