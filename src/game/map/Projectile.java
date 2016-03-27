package game.map;


import tool.LOGGER;

/**
 * 
 */
public class Projectile {
Cell aCell;

    /**
     * @param cell
     */

    public Projectile(Cell cell) {

        this.aCell=cell;
       LOGGER.ProjectileLaunched();
    }

    /**
     * @param quarter
     */
    public void launch(Quarter quarter) {
        Cell nCell= aCell.getNeighbour(quarter);
        while (!nCell.testProjectile(quarter)){
        LOGGER.ProjectilePassedCell(aCell);
        aCell=nCell;

        nCell= aCell.getNeighbour(quarter);
}


    }

}