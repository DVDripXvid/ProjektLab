package game.cellelements;

import game.cellelements.doors.Exit;
import game.map.Cell;
import game.map.Projectile;
import game.roles.CellElement;
import game.roles.Movable;

public class Box extends CellElement implements Movable {

    private int weight;
    private Cell actualCell;

    public Box() {
    }

    public Box(int weight, Cell actualCell) {
        this.weight = weight;
        this.actualCell = actualCell;
    }

    public Cell getActualCell() {
        return actualCell;
    }

    public void setActualCell(Cell actualCell) {
        this.actualCell = actualCell;
    }    

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override                           // a függvény felülírása az aktuális osztályra
    public boolean take(Movable movable) {         // doboz felvétele, azaz önmaga átadása
        movable.accept(this);
        return true;
    }

    @Override                           // a függvény felülírása az aktuális osztályra
    public boolean enterMovable(Movable movable) {     //lekérdezzük, hogy jöhet-e Movable
        return meetWith(this);
    }

    @Override                           // a függvény felülírása az aktuális osztályra
    public boolean obstacleForProjectile(Projectile projectile) { //Lekérdezzük, hogy akadály-e a lövedéknek
        return true;                    // a doboz megálítja a lövedéket
    }

    @Override
    public void meetWith(Abyss abyss) {
        actualCell.removeElement(this);
    }

    @Override
    public void meetWith(Exit exit) {
        //don't care
    }

    @Override
    public void meetWith(ZPM zpm) {
        actualCell.removeElement(zpm);
        zpm.destroy();
    }

    @Override
    public boolean meetWith(Box box) {
        return true;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void accept(Box box) {
        //no thx
        throw new UnsupportedOperationException("box shuldn't try to take another box");
    }

}
