package LastWhisper_classes;

/**
 * Created by Martin on 04/12/2015.
 */
public class Cell {
    private int xPosition;
    private int yPosition;
    private boolean isVacant;

    public Cell(int xPosition, int yPosition, boolean isVacant) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.isVacant = isVacant;
    }
}
