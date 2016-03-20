package game.roles;

import game.map.Cell;
import game.map.Quarter;

/**
 * Created by Ádám on 20/03/2016.
 */

public final class Portal{

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