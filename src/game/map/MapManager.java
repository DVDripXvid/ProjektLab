package game.map;

import game.cellelements.Box;
import game.cellelements.Scales;
import game.cellelements.Wall;
import game.cellelements.ZPM;
import game.cellelements.doors.Exit;
import game.cellelements.doors.Gate;
import game.roles.CellElement;
import game.roles.Player;
import game.roles.Replicator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Térkép menedzser osztálya
 */
public enum MapManager {

    INSTANCE;

    int rowCount = 0;
    int columnCount = 0;
    private Cell[][] map;
    private final Map<Cell, Coordinate> cells = new HashMap();
    private final Map<String, Player> players = new HashMap();
    private final Map<Integer, ScalesBinding> scalesBindings = new HashMap<>();
    private Replicator replicator = null;
    public final Object turn = new Object();
    private boolean randomizingZPM = false;
    private boolean randomReplicator = false;

    /**
     * Térkép létrehozása.
     */
    public void loadMap() {
        // TODO implement here
    }

    /**
     * ZPM random helyre helyezése a térképen
     */
    public void createZPM() {
        if(!randomizingZPM){
            return;
        }
        Random rnd = new Random();
        int randomRow = rnd.nextInt(rowCount - 2) + 1;
        int randomColumn = rnd.nextInt(columnCount - 2) + 1;
        while (!map[randomRow][randomColumn].getElementList().isEmpty()) {
            randomRow = rnd.nextInt(rowCount - 2) + 1;
            randomColumn = rnd.nextInt(columnCount - 2) + 1;
        }
        System.out.println("zpm created at " + randomRow + " " + randomColumn);
        map[randomRow][randomColumn].addElement(new ZPM());
    }

    public int maxWayLength() {
        return rowCount + columnCount;
    }

    public void createMap(int row, int column) {
        rowCount = row + 2;
        columnCount = column + 2;
        map = new Cell[rowCount][columnCount];

        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                Cell cell = new Cell();
                if (i == 0 || i == rowCount - 1 || j == 0 || j == columnCount - 1) {
                    cell.addElement(new Wall());
                }
                map[i][j] = cell;
                cells.put(cell, new Coordinate(i, j));
            }
        }
        setNeighbours();
        System.out.println("map created");
    }

    private void setNeighbours() {
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < columnCount; ++j) {
                if (i < rowCount - 1) {
                    map[i][j].setNeighbourhood(Quarter.SOUTH, map[i + 1][j]);
                }
                if (j < columnCount - 1) {
                    map[i][j].setNeighbourhood(Quarter.EAST, map[i][j + 1]);
                }
            }
        }
    }

    public boolean checkBounds(int row, int column) {
        return row < rowCount - 1 && row > 0 && column < columnCount - 1 && column > 0;
    }

    public Cell getCellAt(int row, int column) {
        return map[row][column];
    }

    public Coordinate getCoordinate(Cell cell) {
        return cells.get(cell);
    }

    public void add(Player player, String name) {
        if (!players.containsKey(name)) {
            players.put(name, player);
            System.out.println(name + " created at " + getCoordinate(player.getActualCell()));
            player.getActualCell().acceptMovable(player);
        } else {
            System.out.println(name + " already exist");
        }
    }

    public void add(Exit exit, Cell cell) {
        if (!ZPM.isThereEXIT()) {
            System.out.println("exit created at " + getCoordinate(cell));
            cell.addElement(exit);
            ZPM.setEXIT(exit);
        }
    }

    public void addNonSpecific(CellElement cellElement, Cell cell) {
        System.out.println(cellElement.getClass().getSimpleName().toLowerCase() + " created at " + getCoordinate(cell));
        cell.addElement(cellElement);
    }

    public void add(Box box, Cell cell) {
        System.out.println("box created at " + getCoordinate(cell));
        cell.addElement(box);
        cell.acceptMovable(box);
    }

    public void add(Replicator replicator, Cell cell) {
        if(this.replicator != null){
            throw new IllegalArgumentException("replicator already exist");
        }
        System.out.println("replicator created at " + getCoordinate(cell));
        this.replicator = replicator;
        replicator.setSelfControlled(randomReplicator);
        cell.addElement(replicator);
        cell.acceptMovable(replicator);
    }

    public void add(Scales scales, Cell cell, Integer id) {
        cell.addElement(scales);
        System.out.println("scales created at " + getCoordinate(cell));
        ScalesBinding binding = scalesBindings.get(id);
        if (binding == null) {
            binding = new ScalesBinding();
            scalesBindings.put(id, binding);
        }
        binding.bind(scales);
    }

    public void add(Gate gate, Cell cell, Integer id) {
        cell.addElement(gate);
        System.out.println("gate created at " + getCoordinate(cell));
        ScalesBinding binding = scalesBindings.get(id);
        if (binding == null) {
            binding = new ScalesBinding();
            scalesBindings.put(id, binding);
        }
        binding.bind(gate);
    }

    public Player getPlayer(String name) {
        if (!players.containsKey(name)) {
            throw new IllegalArgumentException("player does not exist");
        }
        return players.get(name);
    }

    public void startReplicator(){
        randomReplicator = true;
        System.out.println("replicator random turned on");
        if (replicator != null) {
            if (!replicator.isSelfControlled()) {
                replicator.setSelfControlled(true);
                new Thread(replicator).start();
            }
        }
    }

    public void stopReplicator() {
        randomReplicator = false;
        System.out.println("replicator random turned off");
        if(replicator != null) {
            replicator.setSelfControlled(false);
        }
    }

    public class Coordinate {

        int row;
        int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return row + " " + column;
        }
    }

    private class ScalesBinding {

        private Scales scales = null;
        private Gate gate = null;

        public void bind(Scales scales) {
            if (this.scales == null) {
                scales.setGate(gate);
                this.scales = scales;
            }
        }

        public void bind(Gate gate) {
            if (this.gate == null) {
                if (scales != null) {
                    scales.setGate(gate);
                }
                this.gate = gate;
            }
        }
    }

    public String getPlayerName(Player player) {
        for (Map.Entry<String, Player> entry : players.entrySet()) {
            if (entry.getValue().equals(player)) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("unknown player");
    }

    public Replicator getReplicator() {
        if(replicator == null){
            throw new IllegalArgumentException("replicator does not exist");
        }
        return replicator;
    }

    public void removePlayer(Player player) {
        players.remove(getPlayerName(player));
    }

    public void removeReplicator() {
        replicator.setSelfControlled(false);
        replicator = null;
    }

    public void setRandomizingZPM(boolean randomizingZPM) {
        this.randomizingZPM = randomizingZPM;
        if (randomizingZPM) {
            System.out.println("zpm random turned on");
        } else {
            System.out.println("zpm random turned off");
        }
    }
}
