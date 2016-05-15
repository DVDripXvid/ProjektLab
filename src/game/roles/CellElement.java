package game.roles;

import graphics.UiElement;

/**
 * Minden mező elemnek az ősosztálya.
 */
public abstract class CellElement {

    private UiElement uiElement;

    public void setUiElement(UiElement ui){
        uiElement = ui;
    }

    public void update(){
        uiElement.update();
    }

    /**
     *
     * @param movable
     */
    public void acceptMovable(Movable movable) {
    }

    /**
     * @param projectile
     * @return
     */
    public boolean obstacleForProjectile(Projectile projectile) {//Lekérdezzük, hogy akadály-e a lövedéknek
        return false;
    }

    /**
     * @param movable the value of movable
     * @return the boolean
     */
    public boolean enterMovable(Movable movable) {//lekérdezzük, hogy jöhet-e Movable
        return true;
    }

    /**
     *
     * @param movable the value of par0
     */
    public void exitMovable(Movable movable) {//Jelezzük, hogy elment a Movable
    }

    /**
     *
     * @param movable
     * @return the boolean 
     */
    public boolean take(Movable movable) {
        return false;
    }//A doboz felvételéhez szükséges függvény
    
}
