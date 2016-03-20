package game.roles;

import game.cellelements.Box;
import game.map.Cell;
import game.map.Projectile;
import game.map.Quarter;
import tool.LOGGER;



/**
 * 
 */
public class ONeill implements Movable{
public Cell aCell;
    private Quarter dir;
   private CellElement box;

    /**
     * Default constructor
     */
    public ONeill() {
    }

    public ONeill(Cell a,Quarter quarter) {
        aCell=a;
        dir=quarter;


    }


    /**
     * 
     */
    public void moveTo(Quarter quarter) {
        Cell nCell= aCell.getNeighbour(quarter);
            this.dir=quarter;
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
        Projectile bullet= new Projectile(this.aCell);
        bullet.launch(dir);

    }

    /**
     * 
     */
    public void boxUp() {

        box= aCell.getNeighbour(dir).take();


    }

    /**
     * 
     */
    public void boxDown() {
        Cell nCell= aCell.getNeighbour(dir);
        if (nCell.enterMovable())
        {

           // aCell.acceptMovable(box);
        if(box!=null) {
            aCell.getNeighbour(dir).placeBox(box);

        }
    }}

}