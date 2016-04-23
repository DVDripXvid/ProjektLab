package tool;

import game.cellelements.Abyss;
import game.cellelements.Box;
import game.cellelements.Scales;
import game.cellelements.ShootableWall;
import game.cellelements.Wall;
import game.cellelements.ZPM;
import game.cellelements.doors.Exit;
import game.cellelements.doors.Gate;
import game.map.Cell;
import game.map.MapManager;
import game.map.Quarter;
import game.roles.CellElement;
import game.roles.Player;
import game.roles.Projectile;
import game.roles.Replicator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Olivér
 */
public class Commander {

    public void process(String command) {
        String[] params = command.split(" ");
        String cmd = params[0];
        try {
            switch (cmd) {
                case "move":
                    validateNumberOfParams(params, 2);
                    move(params[1], params[2]);
                    break;
                case "create":
                    create(params);
                    break;
                case "setmap":
                    validateNumberOfParams(params, 2);
                    setmap(params[1], params[2]);
                    break;
                case "shoot":
                    validateNumberOfParams(params, 1);
                    shoot(params[1]);
                    break;
                case "changecolor":
                    validateNumberOfParams(params, 1);
                    changecolor(params[1]);
                    break;
                case "take":
                    validateNumberOfParams(params, 1);
                    take(params[1]);
                    break;
                case "put":
                    validateNumberOfParams(params, 1);
                    put(params[1]);
                    break;
                case "query":
                    validateNumberOfParams(params, 2);
                    query(params[1], params[2]);
                    break;
                case "delete":
                    validateNumberOfParams(params, 2);
                    delete(params[1], params[2]);
                    break;
                case "random":
                    validateNumberOfParams(params, 2);
                    random(params[1], params[2]);
                    break;
                case "load":
                    validateNumberOfParams(params, 1);
                    load(params[1]);
                    break;
                default:
                    Printer.print("unknown command");
            }
        } catch (IllegalArgumentException exception) {
            Printer.print(exception.getMessage());
        }
    }

    private void validateNumberOfParams(String[] params, int number) {
        if (params.length - 1 != number) {
            throw new IllegalArgumentException("incorrect number of parameters");
        }
    }

    private void checkNumberOfParams(String[] params, int number) {
        if (params.length - 1 < number) {
            throw new IllegalArgumentException("too few parameter");
        }
    }

    private void move(String playerString, String directionString) {
        if (playerString.equals("replicator")) {
            MapManager.INSTANCE.getReplicator().moveTo(Quarter.valueOf(directionString.toUpperCase()));
        } else {
            MapManager.INSTANCE.getPlayer(playerString).moveTo(Quarter.valueOf(directionString.toUpperCase()));
        }
    }

    private void shoot(String playerString) {
        MapManager.INSTANCE.getPlayer(playerString).shoot();
    }

    private void changecolor(String playerString) {
        MapManager.INSTANCE.getPlayer(playerString).changeColor();
    }

    private void take(String playerString) {
        MapManager.INSTANCE.getPlayer(playerString).boxUp();
    }

    private void put(String playerString) {
        MapManager.INSTANCE.getPlayer(playerString).boxDown();
    }
    
    private void random(String elementString, String switchString){
        switch(elementString){
            case "replicator":
                if(switchString.equals("on")){
                    MapManager.INSTANCE.startReplicator();
                }else if (switchString.equals("off")) {
                    MapManager.INSTANCE.stopReplicator();
                }else{
                     throw new IllegalArgumentException("random command second parameter options: on, off");
                }
                break;
            case "zpm":
                if(switchString.equals("on")){
                    MapManager.INSTANCE.setRandomizingZPM(true);
                }else if (switchString.equals("off")) {
                    MapManager.INSTANCE.setRandomizingZPM(false);
                }else{
                    throw new IllegalArgumentException("random command second parameter options: on, off");
                }
                break;
            default:
                throw new IllegalArgumentException("random first parameter options: replicator, zpm");
        }
    }

    private void query(String rowString, String columnString) {
        int row = Integer.parseInt(rowString);
        int column = Integer.parseInt(columnString);
        if (!MapManager.INSTANCE.checkBounds(row, column)) {
            throw new IllegalArgumentException("coordinates out of bounds");
        }
        Cell cell = MapManager.INSTANCE.getCellAt(row, column);

        List<CellElement> elements = cell.getElementList();
        if(elements.isEmpty()){
            Printer.print("nothing is here");
        }
        for (CellElement element : elements) {
            Printer.print(element.getClass().getSimpleName().toLowerCase());
        }
    }

    private void create(String... params) {
        checkNumberOfParams(params, 3);
        int row = Integer.parseInt(params[2]);
        int column = Integer.parseInt(params[3]);
        if (!MapManager.INSTANCE.checkBounds(row, column)) {
            throw new IllegalArgumentException("coordinates out of bounds");
        }
        Cell cell = MapManager.INSTANCE.getCellAt(row, column);

        switch (params[1]) {
            case "oneill":
                validateNumberOfParams(params, 4);
                MapManager.INSTANCE.add(new Player(cell, Quarter.EAST, Integer.parseInt(params[4]), Projectile.Color.BLUE), params[1]);
                break;
            case "jaffa":
                validateNumberOfParams(params, 4);
                MapManager.INSTANCE.add(new Player(cell, Quarter.EAST, Integer.parseInt(params[4]), Projectile.Color.RED), params[1]);
                break;
            case "box":
                validateNumberOfParams(params, 4);
                MapManager.INSTANCE.add(new Box(Integer.parseInt(params[4]), cell), cell);
                break;
            case "gate":
                validateNumberOfParams(params, 4);
                MapManager.INSTANCE.add(new Gate(MapManager.INSTANCE.getCoordinate(cell)), cell, Integer.parseInt(params[4]));
                break;
            case "scales":
                validateNumberOfParams(params, 5);
                MapManager.INSTANCE.add(new Scales(Integer.parseInt(params[5])), cell, Integer.parseInt(params[4]));
                break;
            case "abyss":
                validateNumberOfParams(params, 3);
                MapManager.INSTANCE.addNonSpecific(new Abyss(), cell);
                break;
            case "exit":
                validateNumberOfParams(params, 3);
                MapManager.INSTANCE.add(new Exit(MapManager.INSTANCE.getCoordinate(cell)), cell);
                break;
            case "shootable":
                validateNumberOfParams(params, 3);
                MapManager.INSTANCE.addNonSpecific(new ShootableWall(cell), cell);
                break;
            case "wall":
                validateNumberOfParams(params, 3);
                MapManager.INSTANCE.addNonSpecific(new Wall(), cell);
                break;
            case "zpm":
                validateNumberOfParams(params, 3);
                MapManager.INSTANCE.addNonSpecific(new ZPM(), cell);
                break;
            case "replicator":
                validateNumberOfParams(params, 3);
                MapManager.INSTANCE.add(new Replicator(cell), cell);
                break;
            default:
                Printer.print("unknown element");
        }
    }

    private void delete(String rowString, String columnString) {
        int row = Integer.parseInt(rowString);
        int column = Integer.parseInt(columnString);
        if (!MapManager.INSTANCE.checkBounds(row, column)) {
            throw new IllegalArgumentException("coordinates out of bounds");
        }
        MapManager.INSTANCE.getCellAt(row, column).getElementList().clear();
        Printer.print("elements deleted at: " + row + " " + column);
    }

    private void setmap(String rows, String columns) {
        int row = Integer.parseInt(rows);
        int column = Integer.parseInt(columns);

        MapManager.INSTANCE.createMap(row, column);
    }

    private void load(String filename){
        try {
            Scanner scanner = new Scanner(new File(filename));
            Printer.setOutStream("../results/" + filename.split("/")[2]);
            while (scanner.hasNext()) {
                String next = scanner.nextLine();
                process(next);
            }
            Printer.reset();
            scanner.close();
        } catch (FileNotFoundException e) {
            Printer.print("File not found");
        }
    }

}
