package ie.ittralee.entities;

/**
 * Created by Martin on 04/12/2015.
 */
public class Unit {
    private String name;
    private int attackValue;
    private int defenceValue;

    public Unit(String name, int attackValue, int defenceValue) {
        this.name = name;
        this.attackValue = attackValue;
        this.defenceValue = defenceValue;
    }

    public String getName() {
        return name;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public int getDefenceValue() {
        return defenceValue;
    }
}
