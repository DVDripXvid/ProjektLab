package game.cellelements;


import game.cellelements.doors.Exit;
import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Movable;

/**
 * 
 */
public class ZPM extends CellElement{
static Exit exit;
    /**
     * Default constructor
     */
    public ZPM() {
    }

    /**
     * 
     */
    public static int count;

    /**
     * 
     * @param movable
     * @return 
     */
    @Override
    public boolean acceptMovable(Movable movable) {
count--;
      //  if(count ==0) Exit.open();
        return true;
    }

}