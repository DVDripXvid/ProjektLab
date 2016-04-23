package game.roles;

import game.map.Cell;
import game.map.MapManager;
import game.map.Quarter;
import tool.Printer;

/**
 * Lövedék osztálya
 */
public class Projectile {
    /**
     * Aktuális cella, amin a lövedék található.
     */
    Cell actualCell;
    /**
     * Lövedék színe
     */
    Color color = Color.BLUE;
    /**
     * Lövedék haladási iránya.
     */
    Quarter quarter;

    public Projectile(Cell cell, Color color) {//konsrtuktor
        this.color = color;
        this.actualCell = cell;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public Color getColor() {
        return color;
    }

    /**
     * Lövedék elindítása. Az adott irányba folyamatosan lekéri a következő cellára lépés lehetőségét a következő
     * cella testProjectile metódusával és pozitív visszajelzés esetén megváltoztatja az aktuális celláját a szomszéd
     * cellájéra.
     *
     * @param quarter a lövedék haladási iránya
     */
    public void launch(Quarter quarter, int timeout) {
        this.quarter = quarter;
        Cell nCell = actualCell.getNeighbour(quarter);
        int time = 0;
        while (!nCell.testProjectile(this)) {
            actualCell = nCell;
            nCell = actualCell.getNeighbour(quarter);
            if(++time > timeout){
                Printer.print("projectile energy depleted");
                return;
            }
        }
        Printer.print("projectile collided at " + MapManager.INSTANCE.getCoordinate(actualCell));
    }

    /**
     * Lövedék színének fajtái
     */
    public static enum Color {
        BLUE,
        YELLOW,
        RED,
        GREEN;
        
        public Color getPair(){
            switch(this){
                case BLUE:
                    return YELLOW;
                case YELLOW:
                    return BLUE;
                case GREEN:
                    return RED;
                case RED:
                    return GREEN;
            }
            throw new IllegalStateException("Unknown color");
        }
    }

}
