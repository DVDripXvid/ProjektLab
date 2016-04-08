package game.cellelements;

import game.cellelements.doors.Gate;
import game.roles.CellElement;
import game.roles.Movable;
import tool.LOGGER;

public class Scales extends CellElement {

    private int limit;
    private int weight = 0;
    private Gate myGate;

    public Scales(int limit, Gate myGate) {
        this.limit = limit;
        this.myGate = myGate;
    }

    public Scales() {
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    
     public void setGate(Gate gate){
        myGate = gate;
    }

    @Override                       // a függvény felülírása az aktuális osztályra 
    public void acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        weight += movable.getWeight();
        if(myGate.isClosed() && weight >= limit){
            myGate.open();
        }
    }

    @Override                       // a függvény felülírása az aktuális osztályra 
    public void exitMovable(Movable movable) {
        weight -= movable.getWeight();
        if(!myGate.isClosed() && weight < limit){
            myGate.close();
        }
    }

}
