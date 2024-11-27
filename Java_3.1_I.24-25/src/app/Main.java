package app;

import java.util.Scanner;
import vehicles.Car;

public class Main {
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		
		String owner;
		String insurance;
		String engine;
		
		System.out.print("Write the owner name: ");
		owner = input.nextLine();
		System.out.print("Write the insurance number: ");
		insurance = input.nextLine();
		System.out.print("Write the engine type: ");
		engine = input.nextLine();
		
		System.out.println("------");
		Car car = new Car(owner, insurance, engine);
		
		System.out.println(car.printInfo());
		
		System.out.println("Double check:");
		System.out.println("Owner: " + car.getOwnerName() + "\n" +
	                           "Insurance No " + car.getInsuranceNumber() + "\n" +
	                           "Engine type: " + car.getEngineType());
	}
}
