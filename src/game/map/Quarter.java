package game.map;

/**
 * 
 */
public enum Quarter {//Az irányok felsorolása
    
    EAST,
    WEST,
    SOUTH,
    NORTH;
    
    public Quarter opposite(){
        switch (this) {
            case NORTH:
                return Quarter.SOUTH;
            case SOUTH:
                return Quarter.NORTH;
            case EAST:
                return Quarter.WEST;
            case WEST:
                return Quarter.EAST;
        }
        throw new IllegalStateException("Unknown quarter");
    }
    
}