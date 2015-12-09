package ie.ittralee.entities;

/**
 * Created by Martin on 04/12/2015.
 */
public class Unit {
    private UnitName name;
    private int attackValue;
    private int defenceValue;

    public Unit(UnitName name, int attackValue, int defenceValue) {
        this.name = name;
        this.attackValue = attackValue;
        this.defenceValue = defenceValue;
    }

    public UnitName getName() {
        return name;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public int getDefenceValue() {
        return defenceValue;
    }
}
