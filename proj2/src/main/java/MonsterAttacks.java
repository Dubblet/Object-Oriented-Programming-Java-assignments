import java.util.ArrayList;
import java.util.Random;

public class MonsterAttacks {
    public static void main(String[] args) {
        // Create an ArrayList of Enemy objects to store each child class created in the loop.
        ArrayList<Enemy> monstersList = new ArrayList<Enemy>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            // Loops 100 times and picks a random number between 1-4.
            int enemyPicker = random.nextInt(4) + 1;
            // If-Else to pick the type of monster to add from the random number selected.
            if (enemyPicker == 1) {
                // Creates a monster by generating a height and weight within the minimum and maximum ranges given.
                Goblin goblin = new Goblin(rNGRange(5, 10), rNGRange(70, 100));
                monstersList.add(goblin);
            } else if (enemyPicker == 2) {
                // Ghosts are always weightless, so just pass in 0 for the weight instead of calling the RNG.
                Ghost ghost = new Ghost(0, rNGRange(70, 100));
                monstersList.add(ghost);
            } else if (enemyPicker == 3) {
                Ogre ogre = new Ogre(rNGRange(120, 200), rNGRange(200, 300));
                monstersList.add(ogre);
            } else {
                Dragon dragon = new Dragon(rNGRange(1000, 1500), rNGRange(750, 2000));
                monstersList.add(dragon);
            }
        }
        // Loop through the list of monsters and call the attack method for each.
        for (Enemy enemy : monstersList) {
            // Calls the override for each child class to print out their unique attack sound.
            enemy.attack();
        }
    }

    /**
     * A method that generates a random int between 2 given values (Inclusive).
     * @param min The lower bounds for the random number generation.
     * @param max The upper bounds for the random number generation.
     * @return An int, a random number between the min and max passed in.
     */
    public static int rNGRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
