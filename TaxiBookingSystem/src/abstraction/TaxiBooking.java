package abstraction;

import java.util.List;

import EntityClass.Passenger;
import EntityClass.Taxi;
import ManualException.InvalidChoiceException;

public interface TaxiBooking {
	public int calculateTime(char currentLocation,char pickupPoint, char dropPoint) throws InvalidChoiceException;

	public int calculateEarning(char pickupPoint, char dropPoint) throws InvalidChoiceException;
	
	public List<Taxi> getAvailableTaxi(int time) ;
	
	public int setValue(char location) throws InvalidChoiceException;

	public void filler();

	public Taxi getLowEarning(List<Taxi> location);

	public void booker(Passenger passenger) throws InvalidChoiceException;

	public void display();
	
	public void check();
}
