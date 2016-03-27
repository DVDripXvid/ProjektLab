package game.roles;

import game.cellelements.Box;
import game.map.Cell;
import game.map.Projectile;
import game.map.Quarter;
import tool.LOGGER;




public class ONeill implements Movable{
public Cell aCell;//aktuális cella
    private Quarter dir;//erre néz éppen ONeill
   private CellElement box;//A nála lévő doboz


    public ONeill() {
    }//konstruktor

    public ONeill(Cell a,Quarter quarter) {//konstruktor
        aCell=a;
        dir=quarter;


    }


    public void moveTo(Quarter quarter) {//Lép a következő mezőre
        Cell nCell= aCell.getNeighbour(quarter);
            this.dir=quarter;
            if (nCell.enterMovable())
            {aCell.exitMovable();
                aCell=nCell;
                aCell.acceptMovable(this);


        }

    }

    public void shoot() {//kilő egy lövedéket
        Projectile bullet= new Projectile(this.aCell);
        bullet.launch(dir);

    }

    public void boxUp() {//Felvesz egy dobozt

        box= aCell.getNeighbour(dir).take();


    }

    /**
     * 
     */
    public void boxDown() {//Letesz egy dobozt maga elé
        Cell nCell= aCell.getNeighbour(dir);
        if (nCell.enterMovable())
        {

           // aCell.acceptMovable(box);
        if(box!=null) {
            aCell.getNeighbour(dir).placeBox(box);

        }
    }}

}