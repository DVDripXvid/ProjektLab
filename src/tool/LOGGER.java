/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import game.roles.CellElement;
import game.roles.Movable;

/**
 *
 * @author Olivér
 */
public abstract class LOGGER {
    
    //CellElement calls
    public static void leaveCell(CellElement cellElement){
        System.out.println("        Movable leave the " + cellElement);
    }
    
    public static void enterCell(CellElement cellElement){
        System.out.println("        Movable enter the " + cellElement);
    }
    
    public static void askCell(CellElement cellElement){
        System.out.println("        Movable asking the " + cellElement);
    }
    
    public static void meetProjectile(CellElement cellElement){
        System.out.println("        Projectile reached the " + cellElement);
    }
    
    public static void destroyMovable(Movable movable) {
        System.out.println("            " + movable.getName() + " was destroyed");
    }
    
    
}
