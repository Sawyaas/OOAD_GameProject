package ie.ittralee;

import ie.ittralee.entities.Base;
import ie.ittralee.entities.Map;

/**
 * Created by Simon on 09/12/2015.
 */
public class Main {
    public static void main(String[] args) {
        /* Initialisations required before starting the User Case */

        GameInfo gameInfo = GameInfo.getInstance();
        Map map = gameInfo.getMap();
        Base playerBase = gameInfo.getBaseList().get(0);
        Base ennemyBase = gameInfo.getBaseList().get(1);

        /* UC_6.0 Simulation */

        System.out.println("Player goes to the map.");
        map.display();

        System.out.println("Player check the enemy base's info.");
        ennemyBase.displayInfo();

        System.out.println("Player attack the enemy base.");
        ennemyBase.attack(playerBase);
    }
}
