package ie.ittralee;

import ie.ittralee.entities.Unit;
import ie.ittralee.entities.UnitName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 09/12/2015.
 */
public class GameInfo {
    /* --- ATTRIBUTES --- */

    public static GameInfo instance;
    private final Unit[] units;


    /* --- CONSTRUCTORS --- */

    private GameInfo() {
        units = new Unit[6];
        units[0] = new Unit(UnitName.SWORDMEN, 6, 4);
        units[1] = new Unit(UnitName.DOGS, 4, 2);
        units[2] = new Unit(UnitName.SPEARMEN, 5, 5);
        units[3] = new Unit(UnitName.CAVALRIES, 7, 1);
        units[4] = new Unit(UnitName.SIEGE_EQUIPMENTS, 10, 0);
        units[5] = new Unit(UnitName.ARCHERS, 2, 8);
    }


    /* --- GETTERS --- */

    public GameInfo getInstance() {
        if (instance == null)
            instance = new GameInfo();

        return instance;
    }
}
