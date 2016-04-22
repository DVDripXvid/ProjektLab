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
    static Exit EXIT;
    /**
     * Pályán lévő ZPM-ek száma.
     */
    public static int count;

    /**
     * Egy új ZPM létrejöttekor a pályán lévő ZPM-ek számát megnöveljük.
     */
    public ZPM() {//konstruktor
        ++count;
        System.out.println("zpm created");
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
