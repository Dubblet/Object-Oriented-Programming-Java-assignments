public class Ogre extends Enemy{

    /**
     * Constructor for both the params from the parent class.
     * @param weight The Ogre's weight.
     * @param height The Ogre's height.
     */
    public Ogre(int weight, int height) {
        super(weight, height);
    }

    /**
     * Overriding abstract attack method to print out the Ogre's attack sound.
     */
    @Override
    public void attack() {
        System.out.println("Ugh!");
    }
}
