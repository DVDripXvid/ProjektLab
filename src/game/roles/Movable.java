package game.roles;

import tool.LOGGER;

/**
 * 
 */
public interface Movable {

    /**
     * 
     */
    default public void destroy(){//Megsemmisíti a movable-t
         LOGGER.destroyMovable(this);
    }
    
    default public String getName(){
        return this.getClass().getSimpleName();
    }

}