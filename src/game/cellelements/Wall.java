package game.cellelements;

import game.map.Projectile;
import game.roles.CellElement;
import game.roles.Movable;

public class Wall extends CellElement {

    @Override
    public boolean enterMovable(Movable movable) {//lekérdezzük, hogy jöhet-e Movable
        return false;
    }

    @Override
    public boolean obstacleForProjectile(Projectile projectile) {//Lekérdezzük, hogy akadály-e a lövedéknek
        return true;
    }

}
