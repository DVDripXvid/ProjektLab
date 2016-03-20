/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

import game.cellelements.doors.Door;
import game.cellelements.doors.Gate;
import game.map.Cell;
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
    public static void doorStatus(Door door) {
        if(door.isClosed())
        System.out.println("            "+ door + " closed");
        else         System.out.println("            "+ door + " opened");

    }

    public static void gameSuccess() {
        System.out.println("            Game over, success");
    }

    public static void ProjectileLaunched() {
        System.out.println("            Projectile Launched");
    }
    public static void ProjectilePassedCell(Cell cell) {
        System.out.println("            Projectile passed "+cell);
    }




}
