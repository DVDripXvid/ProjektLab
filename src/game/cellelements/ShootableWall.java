package game.cellelements;

import game.map.Cell;
import game.map.MapManager;
import game.roles.Projectile;
import game.map.Quarter;
import java.util.HashMap;
import java.util.Map;

/**
 * Lőhető fal osztálya. A Fal osztály leszármazottja.
 */
public class ShootableWall extends Wall {

    /**
     * A portálokat tároló statikus változó. Tárolja a portálobjektumokat és
     * azok színét.
     */
    private static final Map<Projectile.Color, Portal> PORTALS = new HashMap<>();
    /**
     * Az adott fal cellája.
     */
    private final Cell myCell;

    /**
     * A paraméterül kapott cellát elmenti, mint saját cellát.
     *
     * @param cell a cella, amin a fal található
     */
    public ShootableWall(Cell cell) {
        myCell = cell;
    }

    /**
     * Létrehoz egy portált, szükség esetén át- illetve visszaálltja a megfelelő
     * celláknak a szomszédait.
     *
     * @param projectile az adott lövedék, amely a falba csapódik be
     * @return true, a fal egy akadály a lövedék számára
     */
    @Override
    public boolean obstacleForProjectile(Projectile projectile) {
        
        overridePortal(projectile);

        Portal pairPortal = PORTALS.get(projectile.getColor().getPair());
        Portal sameColorPortal = PORTALS.get(projectile.getColor());
        if (sameColorPortal != null) {
            sameColorPortal.resetNeighbours();
        }
        if (pairPortal != null) {
            pairPortal.resetNeighbours();
        }
        Portal createdPortal = new Portal(myCell, projectile.getQuarter().opposite());
        System.out.println(projectile.getColor().toString().toLowerCase()
                + " portal created: "
                + MapManager.INSTANCE.getCoordinate(myCell));
        PORTALS.put(projectile.getColor(), createdPortal);
        createdPortal.createWormhole(PORTALS.get(projectile.getColor().getPair()));

        return true;
    }

    private void overridePortal(Projectile projectile) {
        Projectile.Color foundColor = null;
        for (Map.Entry<Projectile.Color, Portal> entry : PORTALS.entrySet()) {
            Projectile.Color key = entry.getKey();
            Portal value = entry.getValue();
            if (projectile.getQuarter().opposite().equals(value.getQuarter())
                    && value.getCell().equals(this.myCell)) {
                foundColor = key;
                break;
            }
        }
        if (foundColor != null) {
            PORTALS.remove(foundColor).resetNeighbours();
            System.out.println(foundColor.toString().toLowerCase() + " portal destroyed at " + MapManager.INSTANCE.getCoordinate(myCell));
        }
    }

    /**
     * A portál osztálya.
     */
    private final class Portal {

        /**
         * Melyik mezőn van a portál
         */
        private Cell cell;
        /**
         * A falnak melyik oldalán van a portál.
         */
        private Quarter quarter;
        /**
         * Az a szomszédos mező, amelyre nyílik a portál.
         */
        private Cell neighbourCell;

        public Portal(Cell cell, Quarter quarter) {
            this.cell = cell;
            this.quarter = quarter;
            neighbourCell = cell.getNeighbour(quarter);
        }

        /**
         * Féregjárat létrehozása. A paraméterül kapott portállal létrehoz egy
         * féregjáratot, azaz átállítja a celláknak a portál felőli
         * szomszédságát egymásra.
         *
         * @param otherPortal a féregjárat másik vége
         */
        public void createWormhole(Portal otherPortal) {
            if (otherPortal == null) {
                return;
            }
            neighbourCell.setNeighbour(quarter.opposite(), otherPortal.getNeighbourCell());
            otherPortal.getNeighbourCell().setNeighbour(otherPortal.getQuarter().opposite(), neighbourCell);
            System.out.println("wormhole created between "
                    + MapManager.INSTANCE.getCoordinate(cell)
                    + " and "
                    + MapManager.INSTANCE.getCoordinate(otherPortal.getCell()));
        }

        /**
         * Visszaállítja a szomszéd (portálra nyíló) cella szomszédságát a
         * portál cellájára.
         */
        public void resetNeighbours() {
            neighbourCell.setNeighbour(quarter.opposite(), cell);
        }

        /**
         *
         * @return
         */
        public Cell getNeighbourCell() {
            return neighbourCell;
        }

        /**
         * @param neighbourCell
         */
        public void setNeighbourCell(Cell neighbourCell) {
            this.neighbourCell = neighbourCell;
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
