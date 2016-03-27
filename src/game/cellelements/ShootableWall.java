package game.cellelements;



import game.map.Cell;
import game.map.Quarter;

import java.awt.*;


/**
 * 
 */


public class ShootableWall extends Wall {

    public enum PortalColor {
        BLUE,
        YELLOW;
    }

  public   static PortalColor portalColor = null;
    private static Portal bluePortal;
    private static Portal yellowPortal;
    private Cell myCell;

    public ShootableWall(Cell cell) {
        myCell=cell;
    }


    @Override
    public boolean obstacleForProjectile(Quarter quarter) {

        switch (quarter) {
            case NORTH:
                quarter=Quarter.SOUTH;
                break;
            case SOUTH:
                quarter=Quarter.NORTH;
                break;
            case EAST:
                quarter=Quarter.WEST;
                break;
            case WEST:
                quarter=Quarter.EAST;
                break;
        }
        if(portalColor==PortalColor.BLUE){
            bluePortal.setCell(myCell);
            bluePortal.setQuarter(quarter);
        }
        if(portalColor==PortalColor.YELLOW){
            yellowPortal.setCell(myCell);
            yellowPortal.setQuarter(quarter);
        }
/*if(yellowPortal.getCell()!=null&&bluePortal.getCell()!=null){
    yellowPortal.getCell().setNeighbour(bluePortal.getQuarter(),bluePortal.getCell());
    bluePortal.getCell().setNeighbour(yellowPortal.getQuarter(),yellowPortal.getCell());


}*/

        return true;
    }

    private final class Portal{

        private Cell cell;
        private Quarter quarter;

        public Portal(Cell cell, Quarter quarter) {
            this.cell = cell;
            this.quarter = quarter;
        }

        public Cell getCell() {
            return cell;
        }

        public void setCell(Cell cell) {
            this.cell = cell;
        }

        public Quarter getQuarter() {
            return quarter;
        }

        public void setQuarter(Quarter quarter) {
            this.quarter = quarter;
        }


    }
}