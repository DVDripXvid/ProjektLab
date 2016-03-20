package game.map;

import game.roles.CellElement;
import game.roles.Movable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */
public class Cell {

private HashMap<Quarter,Cell>neighbours;
    private ArrayList<CellElement>ElementList;
    /**
     * Default constructor
     */
    public Cell() {

        ElementList=null;

    }







    /**
     * @param cellElement
     * @return
     */
    public boolean placeBox(CellElement cellElement) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public CellElement take() {
        CellElement visz=null;
        for (int i=0;i<ElementList.size();i++) {
         if(ElementList.get(i).take()!=null)
           visz= ElementList.get(i).take();

        }
        return visz;
    }

    /**
     * @param quarter 
     * @return
     */
    public Cell getNeighbour(Quarter quarter) {
        Cell nCell= neighbours.get(quarter);
        return nCell;
    }

    /**
     * @param quarter 
     * @return
     */
    public boolean testProjectile(Quarter quarter) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean enterMovable() {
        boolean ret=true;
        for (int i=0;i<ElementList.size();i++) {

ret=ret&& ElementList.get(i).enterMovable();
        }




        return ret;
    }

    /**
     * 
     */
    public void exitMovable() {
        for (int i=0;i<ElementList.size();i++)
           ElementList.get(i).exitMovable();


    }

    /**
     * @param movable
     * @return
     */
    public boolean acceptMovable(Movable movable) {
        for (int i=0;i<ElementList.size();i++)
            if(ElementList.get(i).acceptMovable(movable))
                ElementList.remove(i);



        return false;
    }

    /**
     * @param quarter
     * @param cell
     */
    public void setNeighbour(Quarter quarter, Cell cell) {
       neighbours.put(quarter,cell);
    }

    /**
     * @param cellElement
     */
    public void addElement(CellElement cellElement) {
        ElementList.add(cellElement);
    }

    /**
     * 
     */


}