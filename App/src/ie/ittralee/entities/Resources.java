package ie.ittralee.entities;

/**
 * Created by Martin on 04/12/2015.
 */
public class Resources {
    private int foodQuantity;
    private int woodQuantity;
    private int stoneQuantity;

    public Resources(int foodQuantity, int woodQuantity, int stoneQuantity) {
        this.foodQuantity = foodQuantity;
        this.woodQuantity = woodQuantity;
        this.stoneQuantity = stoneQuantity;
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
