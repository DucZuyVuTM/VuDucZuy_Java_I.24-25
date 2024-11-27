package app;

import java.util.Scanner;
import vehicles.Car;
import vehicles.ElectricCar;

public class Main {
	public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
		
		String owner;
		String insurance;
		String engine;
		
		System.out.println("The car is ready.");
		System.out.print("Write the owner name: ");
		owner = input.nextLine();
		System.out.print("Write the insurance number: ");
		insurance = input.nextLine();
		System.out.print("Write the engine type: ");
		engine = input.nextLine();
		
		System.out.println("------");
		Car car = new Car(owner, insurance, engine);
		
		System.out.println(car.printInfo());
		
		System.out.println();
		System.out.println("Double check:");
		System.out.println("Owner: " + car.getOwnerName() + "\n" +
	                           "Insurance No " + car.getInsuranceNumber() + "\n" +
	                           "Engine type: " + car.getEngineType());

		System.out.println("---------");
		
		int battery;

		System.out.println("The e-car is ready.");
		System.out.print("Write the owner name: ");
		owner = input.nextLine();
		System.out.print("Write the insurance number: ");
		insurance = input.nextLine();

		System.out.print("Write the battery capacity: ");
		battery = input.nextInt();
		
		System.out.println("------");
		ElectricCar eCar = new ElectricCar(owner, insurance, battery);
		
		System.out.println(eCar.printInfo());
		System.out.println();
		System.out.println("Double check:");
		System.out.println("Owner: " + eCar.getOwnerName() + "\n" +
	                       	   "Insurance No " + eCar.getInsuranceNumber() + "\n" +
				   "Engine type: " + eCar.getEngineType() + "\n" +
		       		   "Battery capacity: " + eCar.getBatteryCapacity());
		
		System.out.println("------");

		System.out.println("***");
	}
}
