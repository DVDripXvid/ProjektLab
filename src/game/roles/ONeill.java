package game.roles;

import game.cellelements.Box;
import game.map.Cell;
import game.map.Projectile;
import game.map.Quarter;
import tool.LOGGER;

public class ONeill implements Movable {

    public Cell aCell;//aktuális cella
    private Quarter dir;//erre néz éppen ONeill
    private Box box;//A nála lévő doboz

    public ONeill() {
    }//konstruktor

    public ONeill(Cell a, Quarter quarter) {//konstruktor
        aCell = a;
        dir = quarter;

    }

    public void moveTo(Quarter quarter) {//Lép a következő mezőre
        LOGGER.log(this);
        LOGGER.newLevel(this);
        Cell nCell = aCell.getNeighbour(quarter);
        this.dir = quarter;
        LOGGER.sameLevel(this);
        if (nCell.enterMovable()) {
            LOGGER.sameLevel(this);
            aCell.exitMovable();
            aCell = nCell;
            LOGGER.sameLevel(this);
            aCell.acceptMovable(this);

        }
        LOGGER.endLevel(this);
    }

    public void shoot() {//kilő egy lövedéket
        LOGGER.log(this);
        Projectile bullet = new Projectile(this.aCell);
        bullet.launch(dir);

    }

    public void boxUp() {//Felvesz egy dobozt
        LOGGER.log(this);
        box = (Box)aCell.getNeighbour(dir).take();
    }

    /**
     *
     */
    public void boxDown() {//Letesz egy dobozt maga elé
        LOGGER.log(this);
        LOGGER.newLevel(this);
        Cell nCell = aCell.getNeighbour(dir);
        LOGGER.sameLevel(this);
        if (box != null && nCell.placeBox(box)) {
            LOGGER.sameLevel(this);
            aCell.getNeighbour(dir).acceptMovable(box);           
        }
        LOGGER.endLevel(this);
    }

}
