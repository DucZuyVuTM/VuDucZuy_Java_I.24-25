public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Circle clone() {
        return new Circle(this.radius); // Создаем копию объекта
    }

    @Override
    public void display() {
        System.out.println("Circle ---> radius = " + radius);
    }
}
