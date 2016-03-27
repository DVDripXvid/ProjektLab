package game.map;

import tool.LOGGER;

/**
 *
 */
public class Projectile {

    Cell aCell;

    public Projectile(Cell cell) {//konsrtuktor
        LOGGER.log(this);
        this.aCell = cell;
    }

    /**
     * @param quarter
     */
    public void launch(Quarter quarter) {//Elindul a lövedék
        LOGGER.log(this);
        LOGGER.newLevel(this);
        Cell nCell = aCell.getNeighbour(quarter);
        LOGGER.sameLevel(this);
        while (!nCell.testProjectile(quarter)) {
            LOGGER.sameLevel(this);
            aCell = nCell;
            nCell = aCell.getNeighbour(quarter);
        }
        LOGGER.endLevel(this);
    }

}
