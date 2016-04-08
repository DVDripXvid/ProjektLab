package game.roles;

import game.cellelements.Abyss;
import game.cellelements.Box;
import game.cellelements.ZPM;
import game.cellelements.doors.Exit;

/**
 *
 */
public interface Movable {

    public void meetWith(Abyss abyss);
    
    public void meetWith(Exit exit);
    
    public void meetWith(ZPM zpm);
    
    public boolean meetWith(Box box);
    
    public void accept(Box box);
    
    public int getWeight();
    
}
