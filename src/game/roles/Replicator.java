package game.roles;

import game.cellelements.Abyss;
import game.cellelements.Box;
import game.cellelements.ZPM;
import game.cellelements.doors.Exit;
import game.map.Cell;
import game.map.Projectile;
import game.map.Quarter;

/**
 *
 * @author Olivér
 */
public class Replicator extends CellElement implements Runnable, Movable{

    private Cell actualCell;

    public Replicator(Cell actualCell) {
        this.actualCell = actualCell;
    }
    
    @Override
    public void run() {
        //todo
    }
    
    public void moveTo(Quarter quarter){
        Cell neighbourCell = actualCell.getNeighbour(quarter);
        if(neighbourCell.enterMovable(this)){
            actualCell.exitMovable(this);
            actualCell = neighbourCell;
            actualCell.acceptMovable(this);
        }        
    }
    
    @Override
    public boolean obstacleForProjectile(Projectile projectile){
        actualCell.removeElement(this);
        return true;
    }

    @Override
    public void meetWith(Abyss abyss) {
        actualCell.removeElement(abyss);
        actualCell.removeElement(this);
    }

    @Override
    public void meetWith(Exit exit) {
        //don't care
    }

    @Override
    public void meetWith(ZPM zpm) {
        //don't care
    }

    @Override
    public boolean meetWith(Box box) {
        return false;
    }

    @Override
    public void accept(Box box) {
        throw new UnsupportedOperationException("Replicator cannot take box");
    }

    @Override
    public int getWeight() {
        return 0;
    }

    
}
