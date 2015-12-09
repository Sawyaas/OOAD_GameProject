package ie.ittralee.entities;

import java.util.List;

/**
 * Created by marti on 08/12/2015.
 */
public class Map {
    /* --- ATTRIBUTES --- */

    private final Cell[] cells;


    /* --- CONSTRUCTORS --- */

    public Map(Cell[] cells) {
        this.cells = cells;
    }


    /* --- GETTERS --- */

    public Cell getCell(int x, int y) {
        for (Cell cell : cells)
            if (cell.getxPosition() == x && cell.getyPosition() == y)
                return cell;

        return null;
    }


    /* --- METHODS --- */

    public void display() {
        // TODO
    }
}
