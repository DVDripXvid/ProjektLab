package game.cellelements;

import game.cellelements.doors.Gate;
import game.roles.CellElement;
import game.roles.Movable;
import tool.Printer;

/**
 * A mérleg objektumok osztálya.
 */
public class Scales extends CellElement {

    /**
     * Mérleg súlyhatára
     */
    private int limit;
    /**
     * Mérlegre tett súly
     */
    private int weight = 0;
    /**
     * Mérleggel összekötött kapu referenciája
     */
    private Gate myGate;

    public Scales(int limit) {
        this.limit = limit;
    }

    /**
     *
     * @param gate
     */
    public void setGate(Gate gate) {
        myGate = gate;
    }

    /**
     * Egy mozgó objektum mérlegre mozgásának érzékelése.
     *
     * @param movable A belépő mozgó objektum referenciája
     */
    @Override
    public void acceptMovable(Movable movable) {
        weight += movable.getWeight();
        Printer.print("weight on scales: " + weight + "/" + limit);
        if (myGate != null && myGate.isClosed() && weight >= limit) {
            myGate.open();
        }
    }

    /**
     * Egy mozgó objetum mérlegről elmozgásának érzékelése.
     *
     * @param movable a mozgó objektum referenciája
     */
    @Override
    public void exitMovable(Movable movable) {
        if (weight != 0) {
            weight -= movable.getWeight();
        }
        if (myGate != null && !myGate.isClosed() && weight < limit) {
            myGate.close();
        }
    }

}
