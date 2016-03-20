package game.cellelements;



import game.map.Quarter;
import game.roles.Portal;

import java.awt.*;


/**
 * 
 */
public class ShootableWall extends Wall {
static Color proColor=Color.BLUE;         //BIZTOS NEM IDE!!!!!!!!!!!!
    private static Portal bluePortal;
    private static Portal yellowPortal;

    public ShootableWall() {
    }

    /**
     * 
     */



    /**
     * @param quarter
     * @return
     */
    @Override
    public boolean obstacleForProjectile(Quarter quarter) {

        if(proColor==Color.BLUE){


        }


        // TODO implement here
        return true;
    }

}