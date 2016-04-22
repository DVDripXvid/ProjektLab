package game.roles;

import game.map.Cell;
import game.map.Quarter;

/**
 * Lövedék osztálya
 */
public class Projectile {
    /**
     * Aktuális cella, amin a lövedék található.
     */
    Cell aCell;
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
        this.aCell = cell;
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
        Cell nCell = aCell.getNeighbour(quarter);
        int time = 0;
        while (!nCell.testProjectile(this)) {
            aCell = nCell;
            nCell = aCell.getNeighbour(quarter);
            if(++time > timeout) return;
        }
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
