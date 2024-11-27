public class Dog extends Animal {
    // Constructor
    public Dog(int age, double size) {
        super(age, size);
    }

    // Override from class Animal
    @Override
    public int toHumanAge() {
        return getAge() * 7;
    }

    // Override from interface Movable
    @Override
    public void move() {
        System.out.println("Dog is moving...");
    }
}