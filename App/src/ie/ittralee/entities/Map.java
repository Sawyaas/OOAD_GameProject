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

    public Cell[] getCells() {
        return cells;
    }


    /* --- METHODS --- */

    public void display() {
        System.out.println("----------\nMap:");
        for (Cell cell : cells) {
            String display = "Cell ["
                    + cell.getxPosition() + ","
                    + cell.getyPosition() + "] => ";
            if (cell.getBase() == null)
                display += "Empty";
            else {
                if (cell.getBase().getCommander().getCommanderControl() == CommanderControl.PLAYER)
                    display += "Player's Base";
                else
                    display += "AI's Base";
            }
            System.out.println(display);
        }
        System.out.println("----------");
    }
}
