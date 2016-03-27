package game.cellelements;



import game.map.Cell;
import game.map.Quarter;

import java.awt.*;





public class ShootableWall extends Wall {

    public enum PortalColor {//A portál színének fajtái
        BLUE,
        YELLOW;
    }

  public   static PortalColor portalColor = null;//milyen színű lövedéktípus van betöltve
    private static Portal bluePortal;//kék portál
    private static Portal yellowPortal;// sárga portál
    private Cell myCell;// a fal cellája

    public ShootableWall(Cell cell) {
        myCell=cell;
    }//konstruktor


    @Override
    public boolean obstacleForProjectile(Quarter quarter) {//Lekérdezzük, hogy akadály-e a lövedéknek és létrehozzunk a portált

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

    private final class Portal{//Portál belső class

        private Cell cell;//hol van a portál
        private Quarter quarter;//a falnak melyik oldalán

        public Portal(Cell cell, Quarter quarter) {
            this.cell = cell;
            this.quarter = quarter;
        }

        public Cell getCell() {
            return cell;
        }//lekérdezzük a cellát ahol van

        public void setCell(Cell cell) {
            this.cell = cell;
        }////beállítjuk a cellát ahol van

        public Quarter getQuarter() {
            return quarter;
        }//lekérdezzük az irányt amerre néz

        public void setQuarter(Quarter quarter) {
            this.quarter = quarter;
        }//beállítjuk az irányt amerre néz


    }
}