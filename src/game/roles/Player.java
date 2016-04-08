package game.roles;

import game.cellelements.Abyss;
import game.cellelements.Box;
import game.cellelements.ZPM;
import game.cellelements.doors.Exit;
import game.map.Cell;
import game.map.MapManager;
import game.map.Projectile;
import game.map.Quarter;

public class Player implements Movable {

    private MapManager mapManager;
    private int weight;
    private int zpmCount = 0;
    private Cell actualCell; //aktuális cella
    private Quarter dir;//erre néz éppen ONeill
    private Box box;//A nála lévő doboz

    public Player() {
    }//konstruktor

    public Player(Cell cell, Quarter quarter, int weight, MapManager mapManager) {//konstruktor
        actualCell = cell;
        dir = quarter;
        this.weight = weight;
        this.mapManager = mapManager;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void moveTo(Quarter quarter) {//Lép a következő mezőre
        Cell nCell = actualCell.getNeighbour(quarter);
        this.dir = quarter;
        if (nCell.enterMovable(this)) {
            actualCell.exitMovable(this);
            actualCell = nCell;
            actualCell.acceptMovable(this);
        }
    }

    public void shoot() {//kilő egy lövedéket
        Projectile bullet = new Projectile(actualCell);
        bullet.launch(dir);
    }

    public void boxUp() {//Felvesz egy dobozt
        Cell nCell = actualCell.getNeighbour(dir);
        nCell.take(this);
    }
    
    @Override
    public void accept(Box box) {
        box.getActualCell().removeElement(box);
        box.getActualCell().exitMovable(box);
        weight += box.getWeight();
        box.setActualCell(null);
        this.box = box;
    }

    public void boxDown() {//Letesz egy dobozt maga elé
        Cell nCell = actualCell.getNeighbour(dir);
        if (box != null && nCell.enterMovable(box)) {
            nCell.addElement(box);
            box.setActualCell(nCell);
            nCell.acceptMovable(box);
            weight -= box.getWeight();
            box = null;
        }
    }

    @Override
    public void meetWith(Abyss abyss) {
        System.out.println("Game Over " + this.toString() + " died");
    }

    @Override
    public void meetWith(Exit exit) {
        System.out.println(this.toString() + " won the game");
    }

    @Override
    public void meetWith(ZPM zpm) {
        actualCell.removeElement(zpm);
        zpm.destroy();
        if(++zpmCount % 2 == 0){
            mapManager.createZPM();
        }
    }

    @Override
    public boolean meetWith(Box box) {
        return false;
    }

    @Override
    public int getWeight() {
        return weight;
    }

}
