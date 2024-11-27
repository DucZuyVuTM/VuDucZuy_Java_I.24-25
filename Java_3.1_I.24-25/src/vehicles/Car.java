package vehicles;

public class Car {
	private String ownerName;
	private String insuranceNumber;

	protected String engineType;

	public Car(String ownerName, String insuranceNumber, String engineType) {
		this.ownerName = ownerName;
		this.insuranceNumber = insuranceNumber;
		this.engineType = engineType;
	}

	// Getter and Setter for Owner name:
	public void setOwnerName(String ownerNane) {
		this.ownerName = ownerNane;
	}

	public String getOwnerName() {
		return ownerName;
	}

	// Getter and Setter for insurance number:
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	// Getter and Setter for engine type:
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getEngineType() {
		return engineType;
	}
	
	// Return info:
	public String printInfo() {
	    return "Owner: " + ownerName + "\n" +
	           "Insurance No " + insuranceNumber + "\n" +
	           "Engine type: " + engineType;
	}
}