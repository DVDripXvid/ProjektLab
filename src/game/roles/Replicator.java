package game.roles;

import game.cellelements.Abyss;
import game.cellelements.Box;
import game.cellelements.ZPM;
import game.cellelements.doors.Exit;
import game.map.Cell;
import game.map.MapManager;
import game.map.Quarter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Replikátor osztálya
 * @author Rottenhoffer
 */
public class Replicator extends CellElement implements Runnable, Movable{
    /**
     * Aktuális cella, amin a replikátor van.
     */
    private Cell actualCell;
    
    private boolean selfControll;

    public Replicator(Cell actualCell) {
        this.selfControll = false;
        this.actualCell = actualCell;
        System.out.println("replicator created");
    }

    /**
     * A random, időszerű mozgást megvalósító metódus.
     */
    @Override
    public void run() {
        while(selfControll){
            System.out.println("marhára magamtól mozgok");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Replicator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Paraméterül adott irányba lépés megvalósítása. Csak akkor lép, ha a az aktuális cellától lekért
     * szomszéd cella elfogadja a replikátor lépési szándékát a rajta lévő cella elemektől függően.
     *
     * Ha el tud lépni, meghívja az aktuális cella exitMovable metódusát és átadja magát a következő cella
     * acceptMovable metódusának. Kilépés után már az aktuális cella is megváltozik a szomszédcellára.
     *
     * @param quarter elmozdulási irány
     */
    public void moveTo(Quarter quarter){
        Cell neighbourCell = actualCell.getNeighbour(quarter);
        if(neighbourCell.enterMovable(this)){
            System.out.println("moved to: " + MapManager.INSTANCE.getCoordinate(neighbourCell));
            actualCell.exitMovable(this);
            actualCell.removeElement(this);
            actualCell = neighbourCell;
            neighbourCell.addElement(this);
            neighbourCell.acceptMovable(this);
        }else{
            System.out.println("move failure");
        }        
    }

    /**
     * Lövedékkel ütközés esetének kezelése. Ekkor a replikátor elpusztul, azaz meghívja az aktuális cella
     * removeElement metódusát önmagára.
     * @param projectile
     * @return
     */
    @Override
    public boolean obstacleForProjectile(Projectile projectile){
        actualCell.removeElement(this);
        MapManager.INSTANCE.removeReplicator();
        System.out.println("replicator out");
        return true;
    }

    /**
     * Szakadékba lépés esete. Ekkor elpusztul a replikátor, azaz meghívja az aktuális cella
     * removeElement metódusát önmagára, és elpusztítja a paraméterül kapott szakadékot is.
     *
     * @param abyss szakadék
     */
    @Override
    public void meetWith(Abyss abyss) {
        actualCell.removeElement(abyss);
        actualCell.removeElement(this);
        MapManager.INSTANCE.removeReplicator();
        System.out.println("replicator died and abyss filled (with replicator's remnands)");
    }

    /**
     * Kijáratra lépés esete. Ilyenkor nem történik semmi extra.
     * @param exit
     */
    @Override
    public void meetWith(Exit exit) {
        //don't care
    }

    /**
     * ZPM-el való találkozás esete. Ilyenkor nem történik semmi extra.
     * @param zpm
     */
    @Override
    public void meetWith(ZPM zpm) {
        //don't care
    }

    /**
     * Dobozra lépés esete. A doboz akadály a replikátor számára.
     * @param box
     * @return
     */
    @Override
    public boolean meetWith(Box box) {
        return false;
    }

    /**
     * Interfész miatt kötelező, egyébként helyes működés esetén egy sosem be nem álló esemény.
     * @param box adott doboz
     */
    @Override
    public void accept(Box box) {
        throw new UnsupportedOperationException("Replicator cannot take box");
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public Cell getActualCell() {
        return actualCell;
    }

    
}
