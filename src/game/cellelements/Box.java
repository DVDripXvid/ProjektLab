package game.cellelements;

import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public class Box extends CellElement implements Movable{

    /**
     * Default constructor
     */
    public Box() {
    }

    /**
     * @return
     */
    @Override
    public CellElement take() {
        // TODO implement here
        return null;
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}