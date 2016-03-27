package game.cellelements;

import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;


public class Box extends CellElement implements Movable{

    public Box() {
    }

    @Override                           // a függvény felülírása az aktuális osztályra
    public CellElement take() {         // doboz felvétele, azaz önmaga átadása

        return this;
    }
    
    @Override                           // a függvény felülírása az aktuális osztályra
    public boolean enterMovable() {     //lekérdezzük, hogy jöhet-e Movable

        return false;                   // dobozra nem lehet lépni
    }
    
    @Override                           // a függvény felülírása az aktuális osztályra
    public boolean obstacleForProjectile(Quarter quarter) { //Lekérdezzük, hogy akadály-e a lövedéknek

        return true;                    // a doboz megálítja a lövedéket
    }

}