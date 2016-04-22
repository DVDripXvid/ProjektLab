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
import java.util.List;

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
                default:
                    System.out.println("unknown command");
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
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

    private void query(String rowString, String columnString) {
        int row = Integer.parseInt(rowString);
        int column = Integer.parseInt(columnString);
        if (!MapManager.INSTANCE.checkBounds(row, column)) {
            System.out.println("coordinates out of bounds");
        }
        Cell cell = MapManager.INSTANCE.getCellAt(row, column);

        List<CellElement> elements = cell.getElementList();
        for (CellElement element : elements) {
            System.out.println(element.getClass().getSimpleName());
        }
    }

    private void create(String... params) {
        checkNumberOfParams(params, 3);
        int row = Integer.parseInt(params[2]);
        int column = Integer.parseInt(params[3]);
        if (!MapManager.INSTANCE.checkBounds(row, column)) {
            System.out.println("coordinates out of bounds");
            return;
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
                MapManager.INSTANCE.add(new Gate(), cell, Integer.parseInt(params[4]));
                break;
            case "scales":
                validateNumberOfParams(params, 5);
                MapManager.INSTANCE.add(new Scales(Integer.parseInt(params[5])), cell, Integer.parseInt(params[4]));
                break;
            case "abyss":
                MapManager.INSTANCE.addNonSpecific(new Abyss(cell), cell);
                break;
            case "exit":
                MapManager.INSTANCE.addNonSpecific(new Exit(), cell);
                break;
            case "shootable":
                MapManager.INSTANCE.addNonSpecific(new ShootableWall(cell), cell);
                break;
            case "wall":
                MapManager.INSTANCE.addNonSpecific(new Wall(), cell);
                break;
            case "zpm":
                MapManager.INSTANCE.addNonSpecific(new ZPM(), cell);
                break;
            case "replicator":
                MapManager.INSTANCE.add(new Replicator(cell), cell);
                break;
            default:
                System.out.println("unknown element");
        }
    }

    private void delete(String rowString, String columnString) {
        int row = Integer.parseInt(rowString);
        int column = Integer.parseInt(columnString);
        if (MapManager.INSTANCE.checkBounds(row, column)) {
            System.out.println("coordinates out of bounds");
            return;
        }
        MapManager.INSTANCE.getCellAt(row, column).getElementList().clear();
        System.out.println("elements deleted");
    }

    private void setmap(String rows, String columns) {
        int row = Integer.parseInt(rows);
        int column = Integer.parseInt(columns);

        MapManager.INSTANCE.createMap(row, column);
    }

}