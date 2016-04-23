package game.cellelements;

import game.cellelements.doors.Exit;
import game.roles.CellElement;
import game.roles.Movable;

/**
 * A ZPM osztálya.
 */
public class ZPM extends CellElement {
    /**
     * Kijárati ajtó.
     */
    private static Exit EXIT = null;
    /**
     * Pályán lévő ZPM-ek száma.
     */
    private static int count = 0;

    /**
     * Egy új ZPM létrejöttekor a pályán lévő ZPM-ek számát megnöveljük.
     */
    public ZPM() {
        ++count;
    }

    /**
     * A kijárati ajtó settere.
     * @param exit a kijárati ajtó
     */
    public static void setEXIT(Exit exit){
        EXIT = exit;
    }

    public static boolean isThereEXIT() {
        return EXIT != null;
    }

    /**
     * Egy mozgó objektummal való találkozást valósítja meg. Értesíti az önmagával való találkozással úgy,
     * hogy átadja önmagát a mozgó objektum meetWith metódusának.
     * @param movable a mozgó objektum, amivel a találkozás történik
     */
    @Override
    public void acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        movable.meetWith(this);
    }

    /**
     * Destruktor.
     *
     * Ha ez az utolsó ZPM, akkor meghívja a kijárat open metódusát.
     */
    public void destroy(){
        --count;
        if(count <= 0 && EXIT != null) EXIT.open();
    }

}
