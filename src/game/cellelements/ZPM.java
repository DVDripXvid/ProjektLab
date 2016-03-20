package game.cellelements;


import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public class ZPM extends CellElement{

    /**
     * Default constructor
     */
    public ZPM() {
    }

    /**
     * 
     */
    public static int count;

    /**
     * 
     * @param movable
     * @return 
     */
    @Override
    public boolean acceptMovable(Movable movable) {
count--;
        return true;
    }

}