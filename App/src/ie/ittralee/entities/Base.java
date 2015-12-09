package ie.ittralee.entities;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Martin on 04/12/2015.
 */
public class Base {
    /* --- ATTRIBUTES --- */

    private Commander commander;
    private Army army;


    /* --- CONSTRUCTORS --- */

    public Base(Commander commander, Army army) {
        this.commander = commander;
        this.army = army;
    }


    /* --- GETTERS --- */

    public Commander getCommander() {
        return commander;
    }

    public Army getArmy() {
        return army;
    }


    /* --- METHODS --- */

    public void attack(Base attacker) {
        /* Calculate the total attack value of the offensive army
         * and the total defence value of the defencive army */

        int attackValue = attacker.army.sumAttackValues();
        int defenceValue = this.army.sumDefenceValues();

        /* Determine the winner by comparing the attack value
         * and the defence value */

        boolean attackerWon;
        if (attackValue >= defenceValue + defenceValue * 0.5){   // At least 50% higher
            // Offensive side automatically wins
            attackerWon = true;
        } else if (defenceValue >= attackValue + attackValue * 0.5) {    // At least 50% higher
            // Defensive side automatically wins
            attackerWon = false;
        } else {
            double randomValue = Math.random();
            if (randomValue < 0.5) {
                // Defensive side randomly wins
                attackerWon = false;
            } else {
                // Offensive side randomly wins
                attackerWon = true;
            }
        }

        /* Give a random part of the resources and of the remaining units of the losing side
         * to the winning side */

        Base winningSide = (attackerWon) ? attacker : this;
        Base losingSide = (attackerWon) ? this : attacker;
        Resources looserStock = losingSide.commander.getStock();
        Army looserArmy = losingSide.army;
        Map<ResourceName, Integer> resourcesGiven = new HashMap<ResourceName, Integer>();
        Map<UnitName, Integer> unitsGiven = new HashMap<UnitName, Integer>();

        int percentage = (int) Math.random() * 10 + 11;  // Random % between 11 and 20

        int food = looserStock.getFoodQuantity() * (percentage/100);
        int stone = looserStock.getStoneQuantity() * (percentage/100);
        int wood = looserStock.getWoodQuantity() * (percentage/100);

        resourcesGiven.put(ResourceName.FOOD, food);
        resourcesGiven.put(ResourceName.STONE, stone);
        resourcesGiven.put(ResourceName.WOOD, wood);

        int swordmen = looserArmy.getNumOfSwordmen() * (percentage/100);
        int dogs = looserArmy.getNumOfDogs() * (percentage/100);
        int spearmen = looserArmy.getNumOfSpearmen() * (percentage/100);
        int cavalries = looserArmy.getNumOfCavalries() * (percentage/100);
        int siegeEquipments = looserArmy.getNumOfSiegeEquipment() * (percentage/100);
        int archers = looserArmy.getNumOfArchers() * (percentage/100);

        unitsGiven.put(UnitName.SWORDMEN, swordmen);
        unitsGiven.put(UnitName.DOGS, dogs);
        unitsGiven.put(UnitName.SPEARMEN, spearmen);
        unitsGiven.put(UnitName.CAVALRIES, cavalries);
        unitsGiven.put(UnitName.SIEGE_EQUIPMENTS, siegeEquipments);
        unitsGiven.put(UnitName.ARCHERS, archers);

        Commander.transferResources(losingSide.commander, winningSide.commander, resourcesGiven);
        Base.transferUnits(losingSide, winningSide, unitsGiven);

        /* If the defensive side has lost, its base is destroyed */

        if (attackerWon)
            this.destroy();

        /* Show the final battle screen */

        String result = (attackerWon) ? "won" : "lost";
        String finalOutput =
                "You have " + result + "!\n" +
                "Resources " + result + ":\n" +
                "\t- " + food + " Food\n" +
                "\t- " + stone + " Stone\n" +
                "\t- " + wood + " Wood\n" +
                "Units " + result + ":\n" +
                "\t- " + swordmen + " Swordmen\n" +
                "\t- " + dogs + " Dogs\n" +
                "\t- " + spearmen + " Spearmen\n" +
                "\t- " + cavalries + " Cavalries\n" +
                "\t- " + siegeEquipments + " Siege Equipments\n" +
                "\t- " + archers + " Archers";
        System.out.println(finalOutput);
    }

    public void destroy() {
        // TODO
    }

    public void displayInfo() {
        String display = "----------\n"
                + ((commander.getCommanderControl() == CommanderControl.PLAYER) ? "Player" : "AI")
                + "'s Base:";
        display += "\n\t- Swordmen: " + army.getNumOfSwordmen();
        display += "\n\t- Dogs: " + army.getNumOfDogs();
        display += "\n\t- Spearmen: " + army.getNumOfSpearmen();
        display += "\n\t- Cavalries: " + army.getNumOfCavalries();
        display += "\n\t- Siege Equipments: " + army.getNumOfSiegeEquipment();
        display += "\n\t- Archers: " + army.getNumOfArchers();
        display += "\n- Attack Value: " + army.sumAttackValues();
        display += "\n- Defence Value: " + army.sumDefenceValues();
        display += "\n----------";

        System.out.println(display);
    }

    public static void transferUnits(Base from, Base to, java.util.Map<UnitName, Integer> units) {
        // TODO
    }
}
