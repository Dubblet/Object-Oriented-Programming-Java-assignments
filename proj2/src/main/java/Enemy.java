abstract class Enemy {
    // Fields
    private int weight;
    private int height;

    /**
     * Constructor with both params.
     * @param weight The enemy's weight.
     * @param height The eneny's height.
     */
    public Enemy(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    //Getters and Setters for each field.

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Abstract method so each child class' attack sound can be called from the parent.
    public abstract void attack();
}
