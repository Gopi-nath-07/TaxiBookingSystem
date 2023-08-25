package implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import EntityClass.Passenger;
import EntityClass.Taxi;
import ManualException.InvalidChoiceException;
import abstraction.TaxiBooking;

public class TaxiBookingImplementation implements TaxiBooking {

	private static Map<Integer, Passenger> passengerList = new HashMap<Integer, Passenger>();

	List<Taxi> locationA = new LinkedList<Taxi>();
	List<Taxi> locationB = new LinkedList<Taxi>();
	List<Taxi> locationC = new LinkedList<Taxi>();
	List<Taxi> locationD = new LinkedList<Taxi>();
	List<Taxi> locationE = new LinkedList<Taxi>();
	List<Taxi> locationF = new LinkedList<Taxi>();

	private static Map<Character, List<Taxi>> taxiList = new HashMap<Character, List<Taxi>>();

	Taxi taxi1 = new Taxi(001, "loki", true, 'a', 9);
	Taxi taxi2 = new Taxi(002, "leo", true, 'a', 9);
	Taxi taxi3 = new Taxi(003, "rolex", true, 'a', 9);
	Taxi taxi4 = new Taxi(004, "vikram", true, 'a', 9);

	@Override
	public void filler() {
		taxi1.setEarnings(700);
		taxi2.setEarnings(200);
		taxi3.setEarnings(100);
		taxi4.setEarnings(430);
		locationA.add(taxi1);
		locationA.add(taxi2);
		locationA.add(taxi3);
		locationA.add(taxi4);
		taxiList.put('a', locationA);
		taxiList.put('b', locationB);
		taxiList.put('c', locationC);
		taxiList.put('d', locationD);
		taxiList.put('e', locationE);
		taxiList.put('f', locationF);

	}

	@Override
	public Taxi getLowEarning(List<Taxi> location) {
		Taxi min = location.get(0);
		for (Taxi t : location) {
			if (min.getEarnings() > t.getEarnings()) {
				min = t;
			}
		}
		return min;
	}

	@Override
	public List<Taxi> getAvailableTaxi(int time) {
		Set<Character> set = taxiList.keySet();
		List<Taxi> taxi = new LinkedList<Taxi>();
		for (Character c : set) {
			List<Taxi> temp = taxiList.get(c);
			for (Taxi t : temp) {
				if (t.getAvailableTime() > 24)
					t.setAvailability(false);
				if (t.getAvailableTime() == time && t.isAvailability())
					taxi.add(t);
			}
		}
		return taxi;
	}

	@Override
	public int setValue(char location) throws InvalidChoiceException {
		switch (location) {
		case 'a': {
			return 0;
		}
		case 'b': {
			return 1;
		}
		case 'c': {
			return 2;
		}
		case 'd': {
			return 3;
		}
		case 'e': {
			return 4;
		}
		case 'f': {
			return 5;
		}
		default: {
			throw new InvalidChoiceException("Invalid Choice");
		}
		}
	}

	@Override
	public int calculateTime(char currentLocation, char pickupPoint, char dropPoint) throws InvalidChoiceException {
		int arr[] = { setValue(currentLocation), setValue(pickupPoint), setValue(dropPoint) };
		int current = 0;
		int drop = 0;
		if (arr[0] >= arr[1])
			current = arr[0] - arr[1];
		else 
			current = arr[1] - arr[0];
		if (arr[1] >= arr[2])
			drop = arr[1] - arr[2];
		else 
			drop = arr[2] - arr[1];
		if (currentLocation == dropPoint) {
			if (arr[0] > arr[1])
				return (arr[0] - arr[1]) * 2;
			else
				return (arr[1] - arr[0]) * 2;
		} else
			return current + drop;
	}

	public int calculateEarning(char pickupPoint, char dropPoint) throws InvalidChoiceException {
		int pickPoint = setValue(pickupPoint);
		int dPoint = setValue(dropPoint);
		int earning = 0;
		if (pickPoint > dPoint)
			earning = ((pickPoint - dPoint) * 15) * 10 + 50;
		else
			earning = ((dPoint - pickPoint) * 15) * 10 + 50;
		return earning;
	}

	@Override
	public void booker(Passenger passenger) throws InvalidChoiceException {

		if (passenger.getPickupPoint() == passenger.getDropPoint()) {
			System.out.println("Pickup and drop location cannot be same");
			return;
		}
		List<Taxi> timing = getAvailableTaxi(passenger.getTime());
		if (timing.size() != 0) {
			List<Taxi> wishedLocation = new LinkedList<Taxi>();
			for (Taxi taxi : timing) {
				if (taxi.getCurrentLocation() == passenger.getPickupPoint())
					wishedLocation.add(taxi);
			}
			Taxi granted = null;
			if (wishedLocation.size() != 0)
				granted = getLowEarning(wishedLocation);
			else
				granted = getLowEarning(timing);

			taxiList.get(granted.getCurrentLocation()).remove(granted);

			granted.setAvailableTime(granted.getAvailableTime() + calculateTime(granted.getCurrentLocation(),
					passenger.getPickupPoint(), passenger.getDropPoint()));
			granted.setEarnings(
					granted.getEarnings() + calculateEarning(passenger.getPickupPoint(), passenger.getDropPoint()));
			granted.setCurrentLocation(passenger.getDropPoint());
			passenger.setTaxi(granted);
			taxiList.get(passenger.getDropPoint()).add(granted);
			passengerList.put(passenger.getId(), passenger);
			System.out.println("Taxi booked successfully with taxiNumber" + granted.getTaxiId());
		} else if (timing.size() == 0) {
			System.out.println("No Taxi available at this time");
		} else {
			throw new InvalidChoiceException("Invalid Choice");
		}
	}

	@Override
	public void display() {
		Set<Integer> set = passengerList.keySet();
		for (Integer i : set) {
			System.out.println(passengerList.get(i));
		}

	}

	@Override
	public void check() {
		Set<Character> set = taxiList.keySet();
		for (Character c : set) {
			System.out.println(c);
			System.out.println(taxiList.get(c));
		}
	}

}