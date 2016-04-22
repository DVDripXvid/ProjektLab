package game.cellelements.doors;

import game.roles.Movable;

public class Exit extends Gate {

    public Exit() {
        System.out.println("exit created");
    }

    
    
    @Override
    public void acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable így vége a játéknak
        movable.meetWith(this);
    }
}
