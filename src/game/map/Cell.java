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

        ElementList=new ArrayList<CellElement>();
neighbours= new HashMap<Quarter,Cell>();
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
        boolean obstacle=false;
        for (int i=0;i<ElementList.size();i++) {
         obstacle= obstacle || ElementList.get(i).obstacleForProjectile(quarter);

        }

        return obstacle;
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
        Quarter opdir=Quarter.NORTH;
        switch (quarter) {
            case NORTH:
                opdir=Quarter.SOUTH;
                break;
            case SOUTH:
                opdir=Quarter.NORTH;
                break;
            case EAST:
                opdir=Quarter.WEST;
                break;
            case WEST:
                opdir=Quarter.EAST;
                break;
        }


       neighbours.put(quarter,cell);
       // cell.setNeighbour(opdir,this);
      /////////////////////////////////ez itt nem jó


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