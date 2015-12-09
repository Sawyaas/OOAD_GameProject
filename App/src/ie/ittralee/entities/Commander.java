package ie.ittralee.entities;

import java.util.*;

/**
 * Created by Martin on 04/12/2015.
 */
public class Commander {
    /* --- ATTRIBUTES --- */

    private final CommanderControl commanderControl;
    private final Resources stock;


    /* --- CONSTRUCTORS --- */

    public Commander(CommanderControl commanderControl, Resources stock) {
        this.commanderControl = commanderControl;
        this.stock = stock;
    }


    /* --- GETTERS --- */

    public CommanderControl getCommanderControl() {
        return commanderControl;
    }

    public Resources getStock() {
        return stock;
    }


    /* --- METHODS --- */

    public static void transferResources(Commander from, Commander to, java.util.Map<ResourceName, Integer> resources) {
        // TODO
    }
}
