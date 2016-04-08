package game.cellelements;

import game.map.Cell;
import game.roles.CellElement;
import game.roles.Movable;

public class Abyss extends CellElement {

    public Abyss(Cell cell) {
    }

    @Override                                        // a függvény felülírása az aktuális osztályra    
    public void acceptMovable(Movable movable) {  //Jelezzük, hogy megérkezett a Movable
        movable.meetWith(this);
    }

}
