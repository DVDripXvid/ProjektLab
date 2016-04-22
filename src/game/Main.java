package game;

import game.cellelements.Box;
import game.map.Cell;
import game.map.Quarter;
import game.roles.Player;
import java.util.Scanner;
import tool.Commander;

public class Main {
    
    public static void main(String[] args) {
        //medium();
        Commander commander = new Commander();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            
            commander.process(next);
        }
    }

}
