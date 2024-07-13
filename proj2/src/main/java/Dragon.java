public class Dragon extends Enemy {

    /**
     * Constructor for both the params from the parent class.
     * @param weight The Dragon's weight.
     * @param height The Dragon's height.
     */
    public Dragon(int weight, int height) {
        super(weight, height);
    }

    /**
     * Overriding abstract attack method to print out the Dragon's attack sound.
     */
    @Override
    public void attack() {
        System.out.println("Rawr!");
    }
}
