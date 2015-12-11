package ie.ittralee.entities;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import ie.ittralee.GameInfo;

import java.util.HashMap;
import java.util.List;
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
        Army subArmy = attacker.army.delegatingUnits();

        /* Calculate the total attack value of the offensive army
         * and the total defence value of the defencive army */

        int attackValue = subArmy.sumAttackValues();
        int defenceValue = this.army.sumDefenceValues();


        /* Determine the winner by comparing the attack value
         * and the defence value */

        boolean attackerWon;
        if (attackValue >= defenceValue + defenceValue * 0.5){   // At least 50% higher
            // Offensive side automatically wins
            System.out.println("* Attack value at least 50% higher than the defence value => Player automatically wins *");
            attackerWon = true;
        } else if (defenceValue >= attackValue + attackValue * 0.5) {    // At least 50% higher
            // Defensive side automatically wins
            System.out.println("* Defence value at least 50% higher than the attack value => AI automatically wins *");
            attackerWon = false;
        } else {
            System.out.print("* None of the both values is at least 50% higher than the other => Random determination of the winner... ");
            double randomValue = Math.random();
            attackerWon = randomValue >= 0.5;
            System.out.println(((attackerWon) ? "Player" : "AI") + " wins *");
        }

        /* Give a random part of the resources and of the remaining units of the losing side
         * to the winning side */

        Base winningSide = (attackerWon) ? attacker : this;
        Base losingSide = (attackerWon) ? this : attacker;
        Resources looserStock = losingSide.commander.getStock();
        Army looserArmy = losingSide.army;
        Map<ResourceName, Integer> resourcesGiven = new HashMap<>();
        Map<UnitName, Integer> unitsGiven = new HashMap<>();

        int percentage = (int)(Math.random() * 10 + 11);  // Random % between 11 and 20

        System.out.println("* The loosing side will give " + percentage + "% of its resources and units *\n");

        int food = (int)(looserStock.getFoodQuantity() * (percentage/100.d));
        int stone = (int)(looserStock.getStoneQuantity() * (percentage/100.d));
        int wood = (int)(looserStock.getWoodQuantity() * (percentage/100.d));

        resourcesGiven.put(ResourceName.FOOD, food);
        resourcesGiven.put(ResourceName.STONE, stone);
        resourcesGiven.put(ResourceName.WOOD, wood);

        int swordmen = (int)(looserArmy.getNumOfSwordmen() * (percentage/100.d));
        int dogs = (int)(looserArmy.getNumOfDogs() * (percentage/100.d));
        int spearmen = (int)(looserArmy.getNumOfSpearmen() * (percentage/100.d));
        int cavalries = (int)(looserArmy.getNumOfCavalries() * (percentage/100.d));
        int siegeEquipments = (int)(looserArmy.getNumOfSiegeEquipment() * (percentage/100.d));
        int archers = (int)(looserArmy.getNumOfArchers() * (percentage/100.d));

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
            //this.destroy();
                this.conquer(winningSide.commander);

        /* Show the final battle screen */

        String result = (attackerWon) ? "won" : "lost";
        String finalOutput =
                "\n----------\nFinal Battle Screen:\n" +
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
                "\t- " + archers + " Archers" +
                "\n----------";
        System.out.println(finalOutput);
    }

    public void destroy() {
        System.out.println("----------\nThe base is destroyed\n----------");

        GameInfo gameInfo = GameInfo.getInstance();

        for (Cell cell : gameInfo.getMap().getCells())
            if (cell.getBase() == this)
                cell.setBase(null);

        List<Base> baseList = gameInfo.getBaseList();

        for (int i = 0; i < baseList.size(); i++)
            if (baseList.get(i) == this)
                baseList.remove(i);
    }

    public void conquer(Commander newOwner){
        this.commander = newOwner;
        System.out.println("The attacker has conquered the Base. ");


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
