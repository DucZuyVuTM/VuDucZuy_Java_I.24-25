public abstract class Animal implements Movable {
    //--- Properties
    private int _age;
    private double _size;

    //--- Methods

    // Constructor
    public Animal(int age, double size) {
        this._age = age;
        this._size = size;
    }

    // Getter and Setter for 'age'
    public int getAge() {
        return _age;
    }
    public void setAge(int age) {
        this._age = age;
    }

    // Getter and Setter for 'size'
    public double getSize() {
        return _size;
    }
    public void setSize(double size) {
        this._size = size;
    }

    // Abstract methods that must be called in all subclasses
    public abstract int toHumanAge();

    // Override from interface Movable
    @Override
    public void move() {
        System.out.println("Animal is moving...");
    }
}