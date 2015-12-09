package ie.ittralee.entities;

import java.util.*;

/**
 * Created by Martin on 04/12/2015.
 */
public class Commander {
    /* --- ATTRIBUTES --- */

    private Resources stock;


    /* --- CONSTRUCTORS --- */

    public Commander() { }


    /* --- GETTERS --- */

    public Resources getStock() {
        return stock;
    }


    /* --- METHODS --- */

    public static void transferResources(Commander from, Commander to, java.util.Map<ResourceName, Integer> resources) {
        // TODO
    }
}
