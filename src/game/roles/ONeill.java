package game.roles;

import game.map.Cell;
import game.map.Quarter;
import tool.LOGGER;

/**
 * 
 */
public class ONeill implements Movable{
public Cell aCell;
    /**
     * Default constructor
     */
    public ONeill() {
    }

    public ONeill(Cell a) {
        aCell=a;    }


    /**
     * 
     */
    public void moveTo(Quarter irany) {
        Cell nCell= aCell.getNeighbour(irany);
        if (nCell.enterMovable())
        {aCell.exitMovable();
            aCell=nCell;
        aCell.acceptMovable(this);


        }

    }
   /*

    public void moveTo(Quarter irany,Cell szom) {
        Cell nCell= szom;
        if (nCell.enterMovable())
        {aCell.exitMovable();
            aCell=nCell;
            aCell.acceptMovable(this);


        }

    }

    */

    /**
     * 
     */
    public void shoot() {
        // TODO implement here
    }

    /**
     * 
     */
    public void boxUp() {
        // TODO implement here
    }

    /**
     * 
     */
    public void boxDown() {
        // TODO implement here
    }

}