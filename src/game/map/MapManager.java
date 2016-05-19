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

import java.util.*;

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
        System.out.print("zpm created at " + randomRow + " " + randomColumn);
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
            player.getActualCell().acceptMovable(player);
            System.out.println(name + " created");
        }
    }

    public void add(Exit exit, Cell cell) {
        if (!ZPM.isThereEXIT()) {
            cell.addElement(exit);
            ZPM.setEXIT(exit);
        }
    }

    public void addNonSpecific(CellElement cellElement, Cell cell) {
        System.out.println(cellElement.getClass().getSimpleName().toLowerCase() + " created");
        cell.addElement(cellElement);
    }

    public void add(Box box, Cell cell) {
        cell.addElement(box);
        cell.acceptMovable(box);
    }

    public void add(Replicator replicator, Cell cell) {
        if(replicator != null){
            throw new IllegalArgumentException("replicator already exist");
        }
        this.replicator = replicator;
        cell.addElement(replicator);
        cell.acceptMovable(replicator);
    }

    public void add(Scales scales, Cell cell, Integer id) {
        cell.addElement(scales);
        ScalesBinding binding = scalesBindings.get(id);
        if (binding == null) {
            binding = new ScalesBinding();
            scalesBindings.put(id, binding);
        }
        binding.bind(scales);
    }

    public void add(Gate gate, Cell cell, Integer id) {
        cell.addElement(gate);
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

    public void startReplicator() {
        if (!replicator.isSelfControlled()) {
            replicator.setSelfControlled(true);
            new Thread(replicator).start();
        }
    }

    public void stopReplicator() {
        replicator.setSelfControlled(false);
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

        public Scales getScales() {
            return scales;
        }

        public Gate getGate() {
            return gate;
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

    public boolean isRandomizingZPM() {
        return randomizingZPM;
    }

    public void setRandomizingZPM(boolean randomizingZPM) {
        this.randomizingZPM = randomizingZPM;
    }

    public List<Cell> getCellList(){
        List<Cell> cells = new ArrayList<>();
        for(Cell[] row: map){
            cells.addAll(Arrays.asList(row));
        }
        return cells;
    }
}
