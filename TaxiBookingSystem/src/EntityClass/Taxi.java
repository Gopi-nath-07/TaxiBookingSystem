package EntityClass;

public class Taxi {
	private int taxiId;
	private String driverName;
	private boolean availability;
	private char currentLocation;
	private int availableTime;
	private int earnings;
	public Taxi(int taxiId, String driverName,boolean availability, char currentLocation, int availableTime) {
		super();
		this.taxiId = taxiId;
		this.driverName = driverName;
		this.availability = availability;
		this.currentLocation = currentLocation;
		this.availableTime = availableTime;
	}

	@Override
	public String toString() {
		return "Taxi [taxiId=" + taxiId + ", driverName=" + driverName + ", availability=" + availability
				+ ", currentLocation=" + currentLocation + ", availableTime=" + availableTime + ", earnings=" + earnings
				+ "]";
	}

	public int getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(int taxiId) {
		this.taxiId = taxiId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public char getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(char currentLocation) {
		this.currentLocation = currentLocation;
	}

	public int getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(int availableTime) {
		this.availableTime = availableTime;
	}

	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}

}
