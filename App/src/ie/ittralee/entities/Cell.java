package ie.ittralee.entities;

/**
 * Created by Martin on 04/12/2015.
 */
public class Cell {
    private int xPosition;
    private int yPosition;
    private Base base;


    public Cell(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }


    public void setBase(Base base) {
        this.base = base;
    }

    public int getxPosition() {

        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Base getBase() {
        return base;
    }
}
