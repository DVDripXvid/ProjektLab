/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Created by Ádám on 19/03/2016.
 */

package game;

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


    public static void Oneill_move() {
        Cell acCell= new Cell();

        Quarter irany= Quarter.NORTH;
        Cell aCell= new Cell();
        Cell nextCell= new Cell();
       // acCell.setNeighbour(irany, nextCell);
        ONeill oNeill= new ONeill();
        //oNeill.moveTo(irany,nextCell);
        oNeill.moveTo(irany);

    }




    public static void main(String[] args) {

        int c;
        System.out.print("BestInBest Skeleton modell menü:\n");
        System.out.println("1:\tO'Neill mozgása");
        System.out.println("2:\tO'Neill mozgása");
        System.out.println("3:\tO'Neill mozgása");
        System.out.println("4:\tO'Neill mozgása");

        do {  c=Integer.parseInt(read());
            switch (c){
                case 1:
                    System.out.print("1");
                    Oneill_move();



                    break;
                case 2:
                    System.out.print("2");
                    break;
                case 3:





                    break;
                case 4:

                    break;
                case 5:

                    break;
            }  }while (c!=0);

    }



}
