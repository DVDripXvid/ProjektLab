/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.cellelements.Abyss;
import game.roles.CellElement;
import game.roles.ONeill;

/**
 *
 * @author Olivér
 */
public class Main {
    
    public static void main(String[] args) {
        pelda();
    }
    
    public static void pelda(){
        ONeill player = new ONeill();
        CellElement abyss = new Abyss();
        abyss.enterMovable();
        abyss.acceptMovable(player);
        abyss.exitMovable();
    }
    
}
