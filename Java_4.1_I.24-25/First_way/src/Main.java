import java.util.Scanner;

@FunctionalInterface
interface Movable {
    void move();  // The only abstract method of the interface
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age; double size;
        
        System.out.print("Write the age of dog: ");
        age = input.nextInt(); input.nextLine();
        System.out.print("Write the size of dog: ");
        size = input.nextDouble(); input.nextLine();

        System.out.println("------");
        Dog dog = new Dog(age, size);

        System.out.println("------------");

        System.out.print("Write the age of sheep: ");
        age = input.nextInt(); input.nextLine();
        System.out.print("Write the size of sheep: ");
        size = input.nextDouble(); input.nextLine();

        System.out.println("------");
        Sheep sheep = new Sheep(age, size);

        System.out.println("------------");
	System.out.println("The dog is " + dog.toHumanAge() + " years old compared to human");
        System.out.println("The sheep is " + sheep.toHumanAge() + " years old compared to human");
    }
}
