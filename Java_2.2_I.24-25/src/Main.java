import java.util.Scanner;
import java.time.LocalDate;

class Car {
    // Свойства
    private String model;
    private String license;
    private String color;
    private int year;
    
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
        color = "Invisible";
        year = 0;
    }
    
    public Car(String m, String c) {
        model = m;
        license = "(not equipped yet)";
        color = c;
        year = 2024;
    }
    
    public String To_String() {
        return "Car Info:\n" +
               "Model: " + model + "\n" +
               "License: " + license + "\n" +
               "Color: " + color + "\n" +
               "Year: " + year;
    }
    
    public void setModel(String m) {
        model = m;
    }
    
    public void setLicense(String l) {
        license = l;
    }
    
    public void setColor(String c) {
        color = c;
    }
    
    public void setYear(int y) {
        year = y;
    }
    
    public String getModel() {
        return model;
    }
    
    public String getLicense() {
        return license;
    }
    
    public String getColor() {
        return color;
    }
    
    public int getYear() {
        return year;
    }
    
    public int calculateAge() {
        // Lấy thời gian hiện tại
        LocalDate currentDate = LocalDate.now();

        // Lấy năm hiện tại
        int currentYear = currentDate.getYear();
        
        return (currentYear - year);
    }
}

public class Main {
    public static String menu1() {
        return "Car choice:\n" +
               "0) Exit\n" +
               "1) Car 1\n" +
               "2) Car 2\n" +
               "3) Car 3\n" +
               "4) Show details about all cars";
    }
    
    public static String menu2() {
        return "Setting about the car:\n" +
               "0) Exit\n" +
               "1) Change model\n" +
               "2) Change license\n" +
               "3) Change color\n" +
               "4) Change year";
    }
    
    public static void main(String[] args) {
        int choice, choice1;
        String model;
        String license;
        String color;
        int year;
  	    
        Scanner input = new Scanner(System.in);
        
        //----------------------------------------------
        System.out.println("Write the info for car 1:");
        System.out.print("Model: ");
        model = input.nextLine();
        System.out.print("License: ");
        license = input.nextLine();
        System.out.print("Color: ");
        color = input.nextLine();
        System.out.print("Year of issue: ");
        year = input.nextInt(); input.nextLine();
        
        Car car1 = new Car(model, license, color, year);
        //----------------------------------------------
        
        Car car2 = new Car();
        
        //----------------------------------------------
        System.out.println("Write the info for car 3:");
        System.out.print("Model: ");
        model = input.nextLine();
        System.out.print("Color: ");
        color = input.nextLine();
          
  	    Car car3 = new Car(model, color);
  	    //----------------------------------------------
  	    
  	    System.out.println("------");
  	    System.out.println("Car 1: \n" + car1.To_String());
  	    System.out.println("Car 2: \n" + car2.To_String());
  	    System.out.println("Car 3: \n" + car3.To_String());
  	    System.out.println("------");
  	    
  	    System.out.println(menu1());
  	    choice = input.nextInt(); input.nextLine();
  	    
  	    while (choice != 0) {
  	        if (choice == 4) {
  	            System.out.println("------");
          	    System.out.println("Car 1: \n" + car1.To_String());
          	    System.out.println("Car 2: \n" + car2.To_String());
          	    System.out.println("Car 3: \n" + car3.To_String());
          	    System.out.println("------");
          	    
          	    System.out.println(menu1());
  	            choice = input.nextInt(); input.nextLine();
  	            
  	            continue;
  	        }
  	        
  	        System.out.println(menu2());
  	        choice1 = input.nextInt(); input.nextLine();
  	        
  	        if (choice == 1) {
  	            if (choice1 == 1) {
  	                System.out.print("Model: ");
                    model = input.nextLine();
                    car1.setModel(model);
                    System.out.println("New model: " + car1.getModel());
  	            }
  	            
  	            if (choice1 == 2) {
  	                System.out.print("License: ");
                    license = input.nextLine();
                    car1.setLicense(license);
                    System.out.println("New license: " + car1.getLicense());
  	            }
  	            
  	            if (choice1 == 3) {
  	                System.out.print("Color: ");
                    color = input.nextLine();
                    car1.setColor(color);
                    System.out.println("New color: " + car1.getColor());
  	            }
  	            
  	            if (choice1 == 4) {
  	                System.out.print("Year: ");
                    year = input.nextInt(); input.nextLine();
                    car1.setYear(year);
                    System.out.println("New year of issue: " + car1.getYear());
  	            }
  	        }
  	        
  	        if (choice == 2) {
  	            if (choice1 == 1) {
  	                System.out.print("Model: ");
                    model = input.nextLine();
                    car2.setModel(model);
                    System.out.println("New model: " + car2.getModel());
  	            }
  	            
  	            if (choice1 == 2) {
  	                System.out.print("License: ");
                    license = input.nextLine();
                    car2.setLicense(license);
                    System.out.println("New license: " + car2.getLicense());
  	            }
  	            
  	            if (choice1 == 3) {
  	                System.out.print("Color: ");
                    color = input.nextLine();
                    car2.setColor(color);
                    System.out.println("New color: " + car2.getColor());
  	            }
  	            
  	            if (choice1 == 4) {
  	                System.out.print("Year: ");
                    year = input.nextInt(); input.nextLine();
                    car2.setYear(year);
                    System.out.println("New year of issue: " + car2.getYear());
  	            }
  	        }
  	        
  	        if (choice == 3) {
  	            if (choice1 == 1) {
  	                System.out.print("Model: ");
                    model = input.nextLine();
                    car3.setModel(model);
                    System.out.println("New model: " + car3.getModel());
  	            }
  	            
  	            if (choice1 == 2) {
  	                System.out.print("License: ");
                    license = input.nextLine();
                    car3.setLicense(license);
                    System.out.println("New license: " + car3.getLicense());
  	            }
  	            
  	            if (choice1 == 3) {
  	                System.out.print("Color: ");
                    color = input.nextLine();
                    car3.setColor(color);
                    System.out.println("New color: " + car3.getColor());
  	            }
  	            
  	            if (choice1 == 4) {
  	                System.out.print("Year: ");
                    year = input.nextInt(); input.nextLine();
                    car3.setYear(year);
                    System.out.println("New year of issue: " + car3.getYear());
  	            }
  	        }
  	        
  	        System.out.println(menu1());
            choice = input.nextInt(); input.nextLine();
  	    }
  	}
}
