package Execution;

import java.util.Scanner;

import EntityClass.Passenger;
import ManualException.InvalidChoiceException;
import abstraction.TaxiBooking;
import implementation.TaxiBookingImplementation;

public class MainClass {
	public static void main(String[] agrs) {
		TaxiBooking taxiBooking = new TaxiBookingImplementation();
	    taxiBooking.filler();
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to BookTaxi"
					+ "\nEnter 2 to display details"
					+ "\nEnter 3 to check"
					+ "\nEnter 4 to exit"
					+ "\n Enter your choice:");
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter your name"
						+ "\nEnter pickup point"
						+ "\nEnter drop point"
						+ "\nEnter time of boarding");
				String name = scan.next();
				char pickupPoint = scan.next().charAt(0);
				char dropPoint = scan.next().charAt(0);
				int time = scan.nextInt();
				Passenger passenger = new Passenger(name, pickupPoint, dropPoint, time);
				try {
					taxiBooking.booker(passenger);
				} catch (InvalidChoiceException e) {
					System.out.println(e.getMessage());
				}
				
				break;
			}
			case 2: {
				taxiBooking.display();
				break;
			}
			case 3: {
				taxiBooking.check();
				break;
			}
			case 4: {
				System.out.println("Thank you");
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Invalid choice");
			}
			}
		}
	}
}
