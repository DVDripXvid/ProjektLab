package game.cellelements.doors;

import game.map.MapManager;
import game.roles.Projectile;
import game.roles.CellElement;
import game.roles.Movable;
import tool.Printer;

/**
 *
 */
public class Gate extends CellElement {

    protected boolean isClosed;
    private MapManager.Coordinate coordinate;

    public Gate(MapManager.Coordinate coordinate) {
        isClosed = true;
        this.coordinate = coordinate;
    }

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
        Printer.print(this.getClass().getSimpleName().toLowerCase() + " opened at " + coordinate);
        isClosed = false;
    }
    
    public void close(){
        Printer.print(this.getClass().getSimpleName().toLowerCase() + " closed at " + coordinate);
        isClosed = true;
    }

}
