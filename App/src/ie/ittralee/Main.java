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

        System.out.println("\n-> Player goes to the map.\n");
        map.display();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){ }

        System.out.println("\n-> Player check the enemy base's info.\n");
        ennemyBase.displayInfo();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){ }

        System.out.println("\n-> Player attack the enemy base.\n");
        ennemyBase.attack(playerBase);
    }
}
