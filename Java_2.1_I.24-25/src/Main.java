import java.util.Scanner;

class Car {
    // Свойства
    String model;
    String license;
    String color;
    int year;
    
    // Методы
    public Car(String m, String l, String c, int y) {
        model = m;
        license = l;
        color = c;
        year = y;
    }
    
    public Car() {
        model = "Unknown";
        license = "XXX-0000";
        color = "Unknown";
        year = 0;
    }
    
    public Car(String m, String c) {
        model = m;
        license = "(not equipped yet)";
        color = c;
        year = 2024;
    }
}

public class Main {
    public static void main(String[] args) {
        int choice;
        String model;
        String license;
        String color;
        int year;
      
        Car car = null;
      
        Scanner input = new Scanner(System.in);
        System.out.print("Choose a type of input: 4, 0 or 2 parameters? ");
        
        choice = input.nextInt();
        input.nextLine(); // Consume newline character
        
        if (choice == 4) {
            System.out.println("Write 4 parameters of the car:");
                System.out.print("Model: ");
                model = input.nextLine();
                System.out.print("License: ");
                license = input.nextLine();
                System.out.print("Color: ");
                color = input.nextLine();
                System.out.print("Year of issue: ");
                year = input.nextInt();
            
            // Создание объекта класса Car
            car = new Car(model, license, color, year);
            
        } else if (choice == 0) {
            
            // Создание объекта класса Car
            car = new Car();
            
        } else if (choice == 2) {
            System.out.println("Write 2 parameters of the car:");
            System.out.print("Model: ");
            model = input.nextLine();
            System.out.print("Color: ");
            color = input.nextLine();
            
            // Создание объекта класса Car
            car = new Car(model, color);
            
        } else {
            System.out.println("Invalid choice.");
            System.exit(1);
        }
        
        System.out.println("Info about the car:");
        System.out.println("Model: " + car.model);
        System.out.println("License: " + car.license);
        System.out.println("Color: " + car.color);
        System.out.println("Year of issue: " + car.year);
  
        input.close();
    }
}
