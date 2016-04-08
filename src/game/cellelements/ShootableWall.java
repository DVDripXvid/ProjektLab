package game.cellelements;

import game.map.Cell;
import game.map.Projectile;
import game.map.Quarter;
import java.util.HashMap;
import java.util.Map;

public class ShootableWall extends Wall {

    private static final Map<Projectile.Color, Portal> PORTALS = new HashMap<>();
    private final Cell myCell;// a fal cellája

    public ShootableWall(Cell cell) {
        myCell = cell;
    }//konstruktor
    

    /**
     * létrehoz egy portalt
     * szükség esetén át- illetve visszaálltja a megfelelő celláknak a szomszédait
     * @param projectile
     * @return 
     */
    @Override
    public boolean obstacleForProjectile(Projectile projectile) {//Lekérdezzük, hogy akadály-e a lövedéknek és létrehozzunk a portált
        
        Portal pairPortal = PORTALS.get(projectile.getColor().getPair());
        pairPortal.resetNeighbours();
        Portal createdPortal = new Portal(myCell, projectile.getQuarter());
        PORTALS.put(projectile.getColor(), createdPortal);
        createdPortal.createWormhole(PORTALS.get(projectile.getColor().getPair()));       
        
        return true;
    }
    

    private final class Portal {//Portál belső class

        private Cell cell;//hol van a portál
        private Quarter quarter;//a falnak melyik oldalán
        private Cell neighbourCell;

        public Portal(Cell cell, Quarter quarter) {
            this.cell = cell;
            this.quarter = quarter;
            neighbourCell = cell.getNeighbour(quarter);
        }
        
        public void createWormhole(Portal otherPortal){
            if(otherPortal == null) return;
            neighbourCell.setNeighbour(quarter.opposite(), otherPortal.getNeighbourCell());
            otherPortal.getNeighbourCell().setNeighbour(otherPortal.getQuarter().opposite(), neighbourCell);
        }
        
        public void resetNeighbours(){
            neighbourCell.setNeighbour(quarter.opposite(), cell);
        }
        
        public Cell getNeighbourCell() {
            return neighbourCell;
        }

        public void setNeighbourCell(Cell neighbourCell) {
            this.neighbourCell = neighbourCell;
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
