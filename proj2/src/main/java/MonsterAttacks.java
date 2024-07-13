import java.util.ArrayList;
import java.util.Random;

public class MonsterAttacks {
    public static void main(String[] args) {
        ArrayList<Enemy> monstersList = new ArrayList<Enemy>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int enemyPicker = random.nextInt(4) + 1;
            if (enemyPicker == 1) {
                Goblin goblin = new Goblin(rNGRange(5, 10), rNGRange(70, 100));
                monstersList.add(goblin);
            } else if (enemyPicker == 2) {
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
        for (Enemy enemy : monstersList) {
            enemy.attack();
        }
    }

    public static int rNGRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
