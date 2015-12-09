package ie.ittralee.entities;

/**
 * Created by Martin on 04/12/2015.
 */
public class Army {
    private int numOfSwordmen;
    private int numOfDogs;
    private int numOfSpearmen;
    private int numOfCavalries;
    private int numOfSiegeEquipment;
    private int numOfArchers;

    public Army(int numOfSwordmen, int numOfDogs, int numOfSpearmen, int numOfCavalries, int numOfSiegeEquipment, int numOfArchers) {
        this.numOfSwordmen = numOfSwordmen;
        this.numOfDogs = numOfDogs;
        this.numOfSpearmen = numOfSpearmen;
        this.numOfCavalries = numOfCavalries;
        this.numOfSiegeEquipment = numOfSiegeEquipment;
        this.numOfArchers = numOfArchers;
    }

    public int getNumOfSwordmen() {
        return numOfSwordmen;
    }

    public int getNumOfDogs() {
        return numOfDogs;
    }

    public int getNumOfSpearmen() {
        return numOfSpearmen;
    }

    public int getNumOfCavalries() {
        return numOfCavalries;
    }

    public int getNumOfSiegeEquipment() {
        return numOfSiegeEquipment;
    }

    public int getNumOfArchers() {
        return numOfArchers;
    }

    public void setNumOfSwordmen(int numOfSwordmen) {
        this.numOfSwordmen = numOfSwordmen;
    }

    public void setNumOfDogs(int numOfDogs) {
        this.numOfDogs = numOfDogs;
    }

    public void setNumOfSpearmen(int numOfSpearmen) {
        this.numOfSpearmen = numOfSpearmen;
    }

    public void setNumOfCavalries(int numOfCavalries) {
        this.numOfCavalries = numOfCavalries;
    }

    public void setNumOfSiegeEquipment(int numOfSiegeEquipment) {
        this.numOfSiegeEquipment = numOfSiegeEquipment;
    }

    public void setNumOfArchers(int numOfArchers) {
        this.numOfArchers = numOfArchers;
    }
}
