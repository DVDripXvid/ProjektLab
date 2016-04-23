package game.cellelements.doors;

import game.map.MapManager;
import game.roles.Movable;

public class Exit extends Gate {

    public Exit(MapManager.Coordinate coordinate) {
        super(coordinate);
    }

    @Override
    public void acceptMovable(Movable movable) {
        movable.meetWith(this);
    }
}
