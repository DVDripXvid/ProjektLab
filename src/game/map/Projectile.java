package game.map;

/**
 *
 */
public class Projectile {

    Cell aCell;
    Color color;
    Quarter quarter;

    public Projectile(Cell cell) {//konsrtuktor
        this.aCell = cell;
    }

    public Quarter getQuarter() {
        return quarter;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @param quarter
     */
    public void launch(Quarter quarter) {//Elindul a lövedék
        this.quarter = quarter;
        Cell nCell = aCell.getNeighbour(quarter);
        while (!nCell.testProjectile(this)) {
            aCell = nCell;
            nCell = aCell.getNeighbour(quarter);
        }
    }

    public static enum Color {//A portál színének fajtái
        BLUE,
        YELLOW,
        RED,
        GREEN;
        
        public Color getPair(){
            switch(this){
                case BLUE:
                    return YELLOW;
                case YELLOW:
                    return BLUE;
                case GREEN:
                    return RED;
                case RED:
                    return GREEN;
            }
            throw new IllegalStateException("Unknown color");
        }
    }

}
