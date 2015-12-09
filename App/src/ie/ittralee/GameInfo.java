package ie.ittralee;

import ie.ittralee.entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Simon on 09/12/2015.
 */
public class GameInfo {
    /* --- ATTRIBUTES --- */

    public static GameInfo instance;
    private final Map<UnitName, Unit> units;
    private final List<Commander> commanderList;
    private final List<Base> baseList;
    private ie.ittralee.entities.Map map;


    /* --- CONSTRUCTORS --- */

    private GameInfo() {
        units = new HashMap<>(6);
        initUnits();
        commanderList = new ArrayList<>(2);
        initCommanders();
        baseList = new ArrayList<>(2);
        initBases();
        initMap();
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

    public List<Base> getBaseList() {
        return baseList;
    }

    public ie.ittralee.entities.Map getMap() {
        return map;
    }

    /* --- METHODS --- */

    private void initUnits() {
        units.put(UnitName.SWORDMEN, new Unit(UnitName.SWORDMEN, 6, 4));
        units.put(UnitName.DOGS, new Unit(UnitName.DOGS, 4, 2));
        units.put(UnitName.SPEARMEN, new Unit(UnitName.SPEARMEN, 5, 5));
        units.put(UnitName.CAVALRIES, new Unit(UnitName.CAVALRIES, 7, 1));
        units.put(UnitName.SIEGE_EQUIPMENTS, new Unit(UnitName.SIEGE_EQUIPMENTS, 10, 0));
        units.put(UnitName.ARCHERS, new Unit(UnitName.ARCHERS, 2, 8));
    }

    private void initCommanders() {
        commanderList.add(new Commander(
                CommanderControl.PLAYER,
                new Resources(435, 500, 0)
        ));
        commanderList.add(new Commander(
                CommanderControl.AI,
                new Resources(858, 380, 1205)
        ));
    }

    private void initBases() {
        baseList.add(new Base(
                commanderList.get(0),
                new Army(15, 10, 15, 5, 2, 5)
        ));
        baseList.add(new Base(
                commanderList.get(1),
                new Army(10, 5, 8, 0, 5, 5)
        ));
    }

    private void initMap() {
        Cell[] cells = new Cell[35];
        int n = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 7; j++) {
                cells[n] = new Cell(i + 1, j + 1);
                n++;
            }
        map = new ie.ittralee.entities.Map(cells);

        map.getCell(2, 5).setBase(baseList.get(0));
        map.getCell(4, 1).setBase(baseList.get(1));
    }
}
