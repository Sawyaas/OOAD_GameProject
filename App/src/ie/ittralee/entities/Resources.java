package ie.ittralee.entities;

/**
 * Created by Martin on 04/12/2015.
 */
public class Resources {
    private int foodQuantity;
    private int stoneQuantity;
    private int woodQuantity;

    public Resources(int foodQuantity, int stoneQuantity, int woodQuantity) {
        this.foodQuantity = foodQuantity;
        this.stoneQuantity = stoneQuantity;
        this.woodQuantity = woodQuantity;
    }

    public int getFoodQuantity() { return foodQuantity; }

    public int getWoodQuantity() {
        return woodQuantity;
    }

    public int getStoneQuantity() {
        return stoneQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public void setWoodQuantity(int woodQuantity) {
        this.woodQuantity = woodQuantity;
    }

    public void setStoneQuantity(int stoneQuantity) {
        this.stoneQuantity = stoneQuantity;
    }
}
