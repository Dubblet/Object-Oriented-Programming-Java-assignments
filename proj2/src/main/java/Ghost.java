public class Ghost extends Enemy {

    /**
     * Constructor for both the params from the parent class.
     * @param weight The Ghost's weight.
     * @param height The Ghost's height.
     */
    public Ghost(int weight, int height) {
        super(weight, height);
    }

    /**
     * Overriding abstract attack method to print out the Ghost's attack sound.
     */
    @Override
    public void attack() {
        System.out.println("Boo!");
    }
}
