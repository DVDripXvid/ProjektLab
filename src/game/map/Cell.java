package game.map;

import game.roles.CellElement;
import game.roles.Movable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tool.LOGGER;

/**
 *
 */
public class Cell {

    private final Map<Quarter, Cell> neighbours;//Szomszédos cellákat irány szerint tároló map
    private final List<CellElement> ElementList;// a cellán lév Elementeket tartalmazó lista

    public Cell() {  //Default constructor
        ElementList = new ArrayList<>();
        neighbours = new HashMap<>();
    }

    public boolean placeBox(CellElement cellElement) {//Doboz lehelyezése
        LOGGER.log(this);
        LOGGER.newLevel(this);
        boolean allow = true;
        for(CellElement element: ElementList){
            LOGGER.sameLevel(this);
            allow = element.enterMovable();
        }
        LOGGER.endLevel(this);
        return allow;
    }

    /**
     * @return
     */
    public CellElement take() {//Doboz felvétele
        LOGGER.log(this);
        LOGGER.newLevel(this);
        CellElement visz = null;
        for (int i = 0; i < ElementList.size(); i++) {
            LOGGER.sameLevel(this);
            visz = ElementList.get(i).take();
            if (visz != null) {
                visz = ElementList.remove(i);
            }
        }
        LOGGER.endLevel(this);
        return visz;
    }

    public Cell getNeighbour(Quarter quarter) {//Szomszéd irány szerinti lekérése
        Cell nCell = neighbours.get(quarter);
        return nCell;
    }

    public boolean testProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek a rajta lévő Elementek
        LOGGER.log(this);
        boolean obstacle = false;
        for (int i = 0; i < ElementList.size(); i++) {
            obstacle = obstacle || ElementList.get(i).obstacleForProjectile(quarter);

        }

        return obstacle;
    }

    public boolean enterMovable() {//lekérdezzük, hogy jöhet-e Movable
        LOGGER.log(this);
        boolean ret = true;
        for (int i = 0; i < ElementList.size(); i++) {

            ret = ret && ElementList.get(i).enterMovable();
        }

        return ret;
    }

    /**
     *
     */
    public void exitMovable() {//Jelezzük, hogy elment a Movable
        LOGGER.log(this);
        for (int i = 0; i < ElementList.size(); i++) {
            ElementList.get(i).exitMovable();
        }

    }

    public boolean acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        LOGGER.log(this);
        for (int i = 0; i < ElementList.size(); i++) {
            if (ElementList.get(i).acceptMovable(movable)) {
                ElementList.remove(i);
            }
        }

        return false;
    }

    public void setNeighbour(Quarter quarter, Cell cell) {//Szomszéd irány szerinti beállítása
        Quarter opdir = Quarter.NORTH;
        switch (quarter) {
            case NORTH:
                opdir = Quarter.SOUTH;
                break;
            case SOUTH:
                opdir = Quarter.NORTH;
                break;
            case EAST:
                opdir = Quarter.WEST;
                break;
            case WEST:
                opdir = Quarter.EAST;
                break;
        }

        neighbours.put(quarter, cell);

    }

    public void addElement(CellElement cellElement) {
        ElementList.add(cellElement);
    }//Új CellElement ráadása a cellára

}
