package generators;

import java.util.Random;

/**
 * Are o functie care genereaza un numar random de la 1 la 10
 */
public class CostGenerator {
    public static int getCost() {
        Random random = new Random();
        int low=1;
        return random.nextInt(9)+low;
    }
}
