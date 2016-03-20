/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Created by Ádám on 19/03/2016.
 */

package game;

import game.cellelements.*;
import game.cellelements.doors.Exit;
import game.cellelements.doors.Gate;
import game.map.Cell;
import game.map.Quarter;
import game.roles.ONeill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    

    





    public static String read() {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            line = buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }


    public  static void Move()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);

        ONeill o = new ONeill(ce0, Quarter.SOUTH);
        o.moveTo(Quarter.SOUTH);
    }
    public  static void ONeill2Abyss()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);

        Abyss abyss = new Abyss();
        ce1.addElement(abyss);

        ONeill o = new ONeill(ce0,Quarter.SOUTH);
        o.moveTo(Quarter.SOUTH);

    }
    public static void Shoot2Shootable()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();
        Cell ce2 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);
        ce1.setNeighbour(Quarter.SOUTH, ce2);

        ShootableWall swall = new ShootableWall();
        ce2.addElement(swall);

        ONeill o = new ONeill(ce0,Quarter.SOUTH);
        o.shoot();

    }

    public static void Box2Scales()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();
        Cell ce2 = new Cell();
        Cell ce3 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);
        ce1.setNeighbour(Quarter.SOUTH, ce2);
        ce2.setNeighbour(Quarter.SOUTH, ce3);

        Box box = new Box();
        ce1.addElement(box);

        Gate gate = new Gate();
        ce3.addElement(gate);

        Scales scales = new Scales(gate);
        ce2.addElement(scales);

        ONeill o = new ONeill(ce0, Quarter.SOUTH);

        o.boxUp();
        o.moveTo(Quarter.SOUTH);
        o.boxDown();
    }
    public static void Shoot2Obstacle()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();
        Cell ce2 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);
        ce1.setNeighbour(Quarter.SOUTH, ce2);

        Box box = new Box();
        ce1.addElement(box);

        ONeill o = new ONeill(ce0,Quarter.SOUTH);
        o.shoot();

    }
    public static void setNeighbours()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);
    }
    public static void Box2FreeCell()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();
        Cell ce2 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);
        ce1.setNeighbour(Quarter.SOUTH, ce2);

        Box box = new Box();
        ce1.addElement(box);

        ONeill o = new ONeill(ce0, Quarter.SOUTH);

        o.boxUp();
        o.moveTo(Quarter.SOUTH);
        o.boxDown();
    }
    public static void Box2Abyss()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();
        Cell ce2 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);
        ce1.setNeighbour(Quarter.SOUTH, ce2);

        Box box = new Box();
        ce1.addElement(box);

        Abyss abyss = new Abyss();
        ce2.addElement(abyss);

        ONeill o = new ONeill(ce0, Quarter.SOUTH);

        o.boxUp();
        o.moveTo(Quarter.SOUTH);
        o.boxDown();
    }


    public static void ZPM_pickup()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);

        ZPM zpm = new ZPM();
        ce1.addElement(zpm);

        ONeill o = new ONeill(ce0, Quarter.SOUTH);
        o.moveTo(Quarter.SOUTH);

    }
    public static void ONeillExits()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);

        Exit exit = new Exit();
        ce1.addElement(exit);

        ONeill o = new ONeill(ce0, Quarter.SOUTH);
        o.moveTo(Quarter.SOUTH);
    }
    public static void CreatePortal()
    {
        Cell ce0 = new Cell();
        Cell ce1 = new Cell();
        Cell ce2 = new Cell();
        Cell ce3 = new Cell();
        Cell ce4 = new Cell();

        ce0.setNeighbour(Quarter.SOUTH, ce1);
        ce1.setNeighbour(Quarter.SOUTH, ce2);
        ce2.setNeighbour(Quarter.SOUTH, ce3);
        ce3.setNeighbour(Quarter.SOUTH, ce4);

        ShootableWall swall1 = new ShootableWall();
        ce0.addElement(swall1);

        ShootableWall swall2 = new ShootableWall();
        ce4.addElement(swall2);

        ONeill o = new ONeill(ce2, Quarter.SOUTH);

        o.shoot();
        o.moveTo(Quarter.NORTH);
        o.shoot();

    }

    public static void main(String[] args) {

        int c;
        System.out.print("BestInBest Skeleton modell menü:\n");



        System.out.println("1:\tO’Neill mozgása");
        System.out.println("2:\tDoboz elhelyezése mérlegre");
        System.out.println("3:\tO’Neill szakadékba lép");
        System.out.println("4:\tLövedék kilövése egy lőhető falra");
        System.out.println("5:\tSzomszédság beálltása");
        System.out.println("6:\tDoboz áthelyezése");
        System.out.println("7:\tLövedék kilövése egy akadályra");
        System.out.println("8:\tDoboz beleesik a szakadékba");
        System.out.println("9:\tZPM felvétele");
        System.out.println("10:\tO’Neill rálép a kijáratra");
        System.out.println("11:\tFéregárat létrehozása");
        System.out.println("\n\n0:\tKILÉPÉS\n");


        do {  c=Integer.parseInt(read());
            switch (c){
                case 1:
                    Move();
                    break;
                case 2:
                    Box2Scales();
                    break;
                case 3:
                    ONeill2Abyss();
                    break;
                case 4:
                    Shoot2Shootable();
                    break;
                case 5:
                    setNeighbours();
                    break;
                case 6:
                    Box2FreeCell();
                    break;
                case 7:
                    Shoot2Obstacle();
                    break;
                case 8:
                    Box2Abyss();
                    break;
                case 9:
                    ZPM_pickup();
                    break;
                case 10:
                    ONeillExits();
                    break;
                case 11:
                    CreatePortal();
                    break;


            }




        }while (c!=0);

    }



}
