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
    private final List<CellElement> elementList;// a cellán lév Elementeket tartalmazó lista

    public Cell() {  //Default constructor
        elementList = new ArrayList<>();
        neighbours = new HashMap<>();
    }

    /**
     * @param movable the value of movable
     */
    public void take(Movable movable) {//Doboz felvétele
        for (int i = elementList.size() - 1; i >= 0; i--) {
            if (elementList.get(i).take(movable)) {
                return;
            }
        }
    }

    public Cell getNeighbour(Quarter quarter) {//Szomszéd irány szerinti lekérése
        return neighbours.get(quarter);
    }

    public boolean testProjectile(Projectile projectile) {//Lekérdezzük, hogy akadály-e a lövedéknek a rajta lévő Elementek
        boolean obstacle = false;
        for (int i = 0; i < elementList.size(); i++) {
            obstacle = obstacle || elementList.get(i).obstacleForProjectile(projectile);
        }

        return obstacle;
    }

    public boolean enterMovable(Movable movable) {//lekérdezzük, hogy jöhet-e Movable
        boolean ret = true;
        for (int i = 0; i < elementList.size(); i++) {
            ret = ret && elementList.get(i).enterMovable(movable);
        }

        return ret;
    }

    /**
     *
     * @param movable the value of movable
     */
    public void exitMovable(Movable movable) {//Jelezzük, hogy elment a Movable
        for (int i = 0; i < elementList.size(); i++) {
            elementList.get(i).exitMovable(movable);
        }

    }

    public void acceptMovable(Movable movable) {//Jelezzük, hogy megérkezett a Movable
        for (CellElement cellElement : elementList) {
            cellElement.acceptMovable(movable);
        }
    }

    public void setNeighbour(Quarter quarter, Cell cell) {//Szomszéd irány szerinti beállítása
        neighbours.put(quarter, cell);
    }

    public void addElement(CellElement cellElement) {
        elementList.add(cellElement);
    }//Új CellElement ráadása a cellára

    public void removeElement(CellElement cellElement) {
        elementList.remove(cellElement);
    }

}
