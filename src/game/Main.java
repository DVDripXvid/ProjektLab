package game;

import java.util.Scanner;

import graphics.View;
import tool.Commander;

public class Main {
    
    public static void main(String[] args) {
        View view = new View();
        view.createMap(5,5);
        view.setVisible(true);

        /*Commander commander = new Commander();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            
            commander.process(next);
        }*/

    }

}
