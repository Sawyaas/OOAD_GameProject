package ie.ittralee;

import ie.ittralee.entities.Unit;
import ie.ittralee.entities.UnitName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Simon on 09/12/2015.
 */
public class GameInfo {
    /* --- ATTRIBUTES --- */

    public static GameInfo instance;
    private final Map<UnitName, Unit> units;


    /* --- CONSTRUCTORS --- */

    private GameInfo() {
        units = new HashMap<UnitName, Unit>();
        units.put(UnitName.SWORDMEN, new Unit(UnitName.SWORDMEN, 6, 4));
        units.put(UnitName.DOGS, new Unit(UnitName.DOGS, 4, 2));
        units.put(UnitName.SPEARMEN, new Unit(UnitName.SPEARMEN, 5, 5));
        units.put(UnitName.CAVALRIES, new Unit(UnitName.CAVALRIES, 7, 1));
        units.put(UnitName.SIEGE_EQUIPMENTS, new Unit(UnitName.SIEGE_EQUIPMENTS, 10, 0));
        units.put(UnitName.ARCHERS, new Unit(UnitName.ARCHERS, 2, 8));
    }


    /* --- GETTERS --- */

    public static GameInfo getInstance() {
        if (instance == null)
            instance = new GameInfo();

        return instance;
    }

    public Map<UnitName, Unit> getUnits() {
        return units;
    }
}
