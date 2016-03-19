package game.map;

import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public class Cell {

    /**
     * Default constructor
     */
    public Cell() {
    }







    /**
     * @param cellElement
     * @return
     */
    public boolean placeBox(CellElement cellElement) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public CellElement take() {
        // TODO implement here
        return null;
    }

    /**
     * @param quarter 
     * @return
     */
    public Cell getNeighbour(Quarter quarter) {
        // TODO implement here
        return null;
    }

    /**
     * @param quarter 
     * @return
     */
    public boolean testProjectile(Quarter quarter) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean enterMovable() {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void exitMovable() {
        // TODO implement here
    }

    /**
     * @param movable
     * @return
     */
    public boolean acceptMovable(Movable movable) {
        // TODO implement here
        return false;
    }

    /**
     * @param quarter
     * @param cell
     */
    public void setNeighbour(Quarter quarter, Cell cell) {
        // TODO implement here
    }

    /**
     * @param cellElement
     */
    public void addElement(CellElement cellElement) {
        // TODO implement here
    }

    /**
     * 
     */
    public enum Quarter {
    }

}