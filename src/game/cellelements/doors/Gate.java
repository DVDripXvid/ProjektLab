package game.cellelements.doors;

import game.roles.Projectile;
import game.roles.CellElement;
import game.roles.Movable;

/**
 *
 */
public class Gate extends CellElement {

    protected boolean isClosed;//zárva vagy nyitva van

    public Gate() {
        isClosed = true;
        System.out.println(getClass().getSimpleName().toLowerCase() + " created");
    }// Default constructor

    public boolean isClosed() {//lekérdezzük, hogy zárva van-e
        return isClosed;
    }

    @Override
    public boolean obstacleForProjectile(Projectile projectile) {//Lekérdezzük, hogy akadály-e a lövedéknek
        return isClosed;
    }

    @Override
    public boolean enterMovable(Movable movable) {//lekérdezzük, hogy jöhet-e Movable
        return !isClosed;
    }
    
    public void open(){
        System.out.println(this.getClass().getSimpleName().toLowerCase() + " opened");
        isClosed = false;
    }
    
    public void close(){
        System.out.println(this.getClass().getSimpleName().toLowerCase() + " closed");
        isClosed = true;
    }

}
