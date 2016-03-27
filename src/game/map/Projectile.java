package game.map;


import tool.LOGGER;

/**
 * 
 */
public class Projectile {
Cell aCell;


    public Projectile(Cell cell) {//konsrtuktor

        this.aCell=cell;
       LOGGER.ProjectileLaunched();
    }

    /**
     * @param quarter
     */
    public void launch(Quarter quarter) {//Elindul a lövedék
        Cell nCell= aCell.getNeighbour(quarter);
        while (!nCell.testProjectile(quarter)){
        LOGGER.ProjectilePassedCell(aCell);
        aCell=nCell;

        nCell= aCell.getNeighbour(quarter);
}


    }

}