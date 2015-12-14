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
        System.out.println("* Transfer of resources... *");

        int food = resources.get(ResourceName.FOOD);
        int stone = resources.get(ResourceName.STONE);
        int wood = resources.get(ResourceName.WOOD);

        int foodFrom =  from.getStock().getFoodQuantity() - food;
        from.getStock().setFoodQuantity(foodFrom);

        int woodFrom = from.getStock().getWoodQuantity() - wood;
        from.getStock().setWoodQuantity(woodFrom);

        int stoneFrom = from.getStock().getStoneQuantity() - stone;
        from.getStock().setStoneQuantity(stoneFrom);

        int foodTo = to.getStock().getFoodQuantity() + food;
        to.getStock().setFoodQuantity(foodTo);

        int woodTo = to.getStock().getWoodQuantity() + wood;
        to.getStock().setWoodQuantity(woodTo);

        int stoneTo = to.getStock().getStoneQuantity() + stone;
        to.getStock().setStoneQuantity(stoneTo);

        System.out.println("*\tFood: " + food);
        System.out.println("*\tStone: " + stone);
        System.out.println("*\tWood: " + wood + '\n');
    }
}
