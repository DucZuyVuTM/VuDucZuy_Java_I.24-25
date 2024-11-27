public class Sheep extends Animal implements Movable {
    // Constructor
    public Sheep(int age, double size) {
        super(age, size);
    }

    // Override from class Animal
    @Override
    public int toHumanAge() {
        return getAge() * 5;
    }

    // Override from interface Movable
    @Override
    public void move() {
        System.out.println("Sheep is moving...");
    }
}