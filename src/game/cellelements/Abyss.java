package game.cellelements;

import game.roles.CellElement;
import game.roles.Movable;

/**
 * Szakadékot megvalósító osztály.
 */
public class Abyss extends CellElement {

    /**
     * Akkor hívódik meg, ha egy mozgó objektum lépett a gazdacellára.
     * Meghívja az objektum meetWith metódusát és átadja paraméterül önmagát.
     * @param movable az adott mozgó objektum
     */
    @Override
    public void acceptMovable(Movable movable) {
        movable.meetWith(this);
    }

}
