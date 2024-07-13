public class Ghost extends Enemy {

    public Ghost(int weight, int height) {
        super(weight, height);
    }

    @Override
    public void attack() {
        System.out.println("Boo!");
    }
}
