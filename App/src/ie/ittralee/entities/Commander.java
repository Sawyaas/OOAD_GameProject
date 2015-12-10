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


        int food =  from.getStock().getFoodQuantity() - resources.get(ResourceName.FOOD);
        from.getStock().setFoodQuantity(food);

        System.out.print(food);

        int wood = from.getStock().getWoodQuantity() - resources.get(ResourceName.WOOD);
        from.getStock().setWoodQuantity(wood);

        System.out.print(wood);

        int stone = from.getStock().getStoneQuantity() - resources.get(ResourceName.STONE);
        from.getStock().setStoneQuantity(stone);

        System.out.print(stone);

        int foodTo = to.getStock().getFoodQuantity() +  resources.get(ResourceName.FOOD);
        to.getStock().setFoodQuantity(foodTo);

        System.out.print(foodTo);

        int woodTo = to.getStock().getWoodQuantity() + resources.get(ResourceName.WOOD);
        to.getStock().setWoodQuantity(woodTo);

        System.out.print(woodTo);

        int stoneTo = to.getStock().getStoneQuantity() + resources.get(ResourceName.STONE);
        to.getStock().setStoneQuantity(stoneTo);

        System.out.print(stoneTo);

    }
}
