package game.cellelements.doors;


import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public abstract class Door extends CellElement{
protected boolean isClosed;//zárva vagy nyitva van


    public Door() {
        isClosed=false;
    }// Default constructor


    @Override
    public boolean acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable

        return false;
    }
public boolean isClosed(){//lekérdezzük, hogy zárva van-e

    return isClosed;
}

    @Override
    public boolean obstacleForProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek

        return false;
    }


    @Override
    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable

        return false;
    }

    @Override
    public void exitMovable() {//Jelezzük, hogy elment a Movable

    }


    @Override
    public CellElement take() {//doboz felvevésnél játszik szerepet, itt nem

        return null;
    }

}