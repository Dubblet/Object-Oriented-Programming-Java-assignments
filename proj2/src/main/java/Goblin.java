public class Goblin extends Enemy {

    /**
     * Constructor for both the params from the parent class.
     * @param weight The Goblin's weight.
     * @param height The Goblin's height.
     */
    public Goblin(int weight, int height) {
        super(weight, height);
    }

    /**
     * Overriding abstract attack method to print out the Goblin's attack sound.
     */
    @Override
    public void attack() {
        System.out.println("Gurgle!");
    }
}
