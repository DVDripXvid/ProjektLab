package game;

import java.util.Scanner;
import tool.Commander;

public class Main {
    
    public static void main(String[] args) {
        Commander commander = new Commander();
        Scanner scanner = new Scanner(System.in);
        
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            if (next.equals("close"))
                break;
            commander.process(next);
        }
        scanner.close();
    }

}
