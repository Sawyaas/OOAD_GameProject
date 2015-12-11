package ie.ittralee.entities;

import ie.ittralee.GameInfo;

import java.util.*;

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


    /* --- METHODS --- */

    public int sumAttackValues() {
        int sum = 0;
        java.util.Map<UnitName, Unit> units = GameInfo.getInstance().getUnits();

        sum += numOfSwordmen * units.get(UnitName.SWORDMEN).getAttackValue();
        sum += numOfDogs * units.get(UnitName.DOGS).getAttackValue();
        sum += numOfSpearmen * units.get(UnitName.SPEARMEN).getAttackValue();
        sum += numOfCavalries * units.get(UnitName.CAVALRIES).getAttackValue();
        sum += numOfSiegeEquipment * units.get(UnitName.SIEGE_EQUIPMENTS).getAttackValue();
        sum += numOfArchers * units.get(UnitName.ARCHERS).getAttackValue();

        return sum;
    }

    public int sumDefenceValues() {
        int sum = 0;
        java.util.Map<UnitName, Unit> units = GameInfo.getInstance().getUnits();

        sum += numOfSwordmen * units.get(UnitName.SWORDMEN).getDefenceValue();
        sum += numOfDogs * units.get(UnitName.DOGS).getDefenceValue();
        sum += numOfSpearmen * units.get(UnitName.SPEARMEN).getDefenceValue();
        sum += numOfCavalries * units.get(UnitName.CAVALRIES).getDefenceValue();
        sum += numOfSiegeEquipment * units.get(UnitName.SIEGE_EQUIPMENTS).getDefenceValue();
        sum += numOfArchers * units.get(UnitName.ARCHERS).getDefenceValue();

        return sum;
    }
    /* This method is used to select an attacking force from the full army*/
    public Army delegatingUnits(){
       System.out.println("Player chooses the units he wants to attack ");
        Army subArmy = new Army(20, 8, 12, 4, 2, 5);
        return subArmy;
    }
}
