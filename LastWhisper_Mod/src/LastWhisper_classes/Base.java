package LastWhisper_classes;

/**
 * Created by Martin on 04/12/2015.
 */
public class Base {
    private int attack;
    private int defence;
    private Base displayInfo;
    private Base transferUnits;
    private Base destroy;

    public Base(int attack, int defence, Base displayInfo, Base transferUnits, Base destroy) {
        this.attack = attack;
        this.defence = defence;
        this.displayInfo = displayInfo;
        this.transferUnits = transferUnits;
        this.destroy = destroy;

    }

    public Base getDisplayInfo() {
        return displayInfo;
    }

    public Base getTransferUnits() {
        return transferUnits;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() { return defence; }

    public Base getDestroy() { return destroy; }

    public void setDestroy(Base destroy) { this.destroy = destroy; }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
