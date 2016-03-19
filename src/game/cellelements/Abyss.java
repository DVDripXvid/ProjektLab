package game.cellelements;

import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;
import tool.LOGGER;

/**
 * 
 */
public class Abyss extends CellElement{

    /**
     * Default constructor
     */
    public Abyss() {
    }

    /**
     * 
     * @param movable
     * @return 
     */
    @Override
    public boolean acceptMovable(Movable movable) {
        LOGGER.enterCell(this);
        movable.destroy();
        return false;
    }

}