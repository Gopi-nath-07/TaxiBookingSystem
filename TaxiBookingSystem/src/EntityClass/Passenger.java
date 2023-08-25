package EntityClass;

public class Passenger {
	private static int passengerId;
	private int id;
	private String passengerName;
	private char pickupPoint;
	private char dropPoint;
	private int time;
	Taxi taxi;
	
	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	public Passenger(String passengerName, char pickupPoint, char dropPoint, int time) {
		super();
		this.id = passengerId++;
		this.passengerName = passengerName;
		this.pickupPoint = pickupPoint;
		this.dropPoint = dropPoint;
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Passenger [passengerName=" + passengerName + ", pickupPoint=" + pickupPoint + ", dropPoint=" + dropPoint
				+ ", time=" + time + ", taxi=" + taxi + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public char getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(char pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public char getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(char dropPoint) {
		this.dropPoint = dropPoint;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}
