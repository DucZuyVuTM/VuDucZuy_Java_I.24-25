package vehicles;

public class ElectricCar extends Car {
    	private int batteryCapacity;

	public ElectricCar(String ownerName, String insuranceNumber, int batteryCapacity){
        	super(ownerName, insuranceNumber, "Electric");
        	this.batteryCapacity = batteryCapacity;
	}

	// Getter and Setter for battery capacity:
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public int getBatteryCapacity() {
		return batteryCapacity;
	}

	// Return info:
	public String printInfo() {
		return "Owner: " + getOwnerName() + "\n" +
	               "Insurance No " + getInsuranceNumber() + "\n" +
		       "Engine type: " + engineType + "\n" +
		       "Battery capacity: " + batteryCapacity;
	}
}