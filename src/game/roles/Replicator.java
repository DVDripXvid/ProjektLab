package game.roles;

import game.cellelements.Abyss;
import game.cellelements.Box;
import game.cellelements.ZPM;
import game.cellelements.doors.Exit;
import game.map.Cell;
import game.map.MapManager;
import game.map.Quarter;
import tool.Printer;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Replikátor osztálya
 *
 * @author Rottenhoffer
 */
public class Replicator extends CellElement implements Runnable, Movable {

    /**
     * Aktuális cella, amin a replikátor van.
     */
    private Cell actualCell;

    private boolean selfControlled;

    public Replicator(Cell actualCell) {
        this.selfControlled = false;
        this.actualCell = actualCell;
    }

    /**
     * A random, időszerű mozgást megvalósító metódus.
     */
    @Override
    public void run() {
        while (selfControlled) {
            synchronized (MapManager.INSTANCE.turn) {
                try {
                    MapManager.INSTANCE.turn.wait();
                    moveTo(randomQuarter());
                } catch (InterruptedException ex) {
                    Printer.print("replicator: error while waiting. message:" + ex.getMessage());
                }
            }
        }
    }

    /**
     * Paraméterül adott irányba lépés megvalósítása. Csak akkor lép, ha a az
     * aktuális cellától lekért szomszéd cella elfogadja a replikátor lépési
     * szándékát a rajta lévő cella elemektől függően.
     *
     * Ha el tud lépni, meghívja az aktuális cella exitMovable metódusát és
     * átadja magát a következő cella acceptMovable metódusának. Kilépés után
     * már az aktuális cella is megváltozik a szomszédcellára.
     *
     * @param quarter elmozdulási irány
     */
    public void moveTo(Quarter quarter) {
        Cell neighbourCell = actualCell.getNeighbour(quarter);
        if (neighbourCell.enterMovable(this)) {
            Printer.print("replicator moved to: " + MapManager.INSTANCE.getCoordinate(neighbourCell));
            actualCell.exitMovable(this);
            actualCell.removeElement(this);
            actualCell = neighbourCell;
            neighbourCell.addElement(this);
            neighbourCell.acceptMovable(this);
        } else {
            Printer.print("replicator move failure");
        }
    }

    /**
     * Lövedékkel ütközés esetének kezelése. Ekkor a replikátor elpusztul, azaz
     * meghívja az aktuális cella removeElement metódusát önmagára.
     *
     * @param projectile
     * @return
     */
    @Override
    public boolean obstacleForProjectile(Projectile projectile) {
        actualCell.removeElement(this);
        MapManager.INSTANCE.removeReplicator();
        Printer.print("replicator out");
        return true;
    }

    /**
     * Szakadékba lépés esete. Ekkor elpusztul a replikátor, azaz meghívja az
     * aktuális cella removeElement metódusát önmagára, és elpusztítja a
     * paraméterül kapott szakadékot is.
     *
     * @param abyss szakadék
     */
    @Override
    public void meetWith(Abyss abyss) {
        actualCell.removeElement(abyss);
        actualCell.removeElement(this);
        MapManager.INSTANCE.removeReplicator();
        Printer.print("replicator died and abyss filled (with replicator's remnants)");
    }

    /**
     * Kijáratra lépés esete. Ilyenkor nem történik semmi extra.
     *
     * @param exit
     */
    @Override
    public void meetWith(Exit exit) {
        //don't care
    }

    /**
     * ZPM-el való találkozás esete. Ilyenkor nem történik semmi extra.
     *
     * @param zpm
     */
    @Override
    public void meetWith(ZPM zpm) {
        //don't care
    }

    /**
     * Dobozra lépés esete. A doboz akadály a replikátor számára.
     *
     * @param box
     * @return
     */
    @Override
    public boolean meetWith(Box box) {
        return false;
    }

    /**
     * Interfész miatt kötelező, egyébként helyes működés esetén egy sosem be
     * nem álló esemény.
     *
     * @param box adott doboz
     */
    @Override
    public void accept(Box box) {
        throw new UnsupportedOperationException("replicator cannot take box");
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public Cell getActualCell() {
        return actualCell;
    }

    public boolean isSelfControlled() {
        return selfControlled;
    }

    public void setSelfControlled(boolean selfControlled) {
        this.selfControlled = selfControlled;
    }
    
    public Quarter randomQuarter(){
        int random = new Random().nextInt(4);
        switch(random){
            case 0:
                return Quarter.SOUTH;
            case 1:
                return Quarter.NORTH;
            case 2:
                return Quarter.WEST;
            case 3:
                return Quarter.EAST;
        }
        throw new IllegalStateException("error at randomizing quarter");
    }

}
