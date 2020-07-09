package code;

import java.io.IOException;

public class CarParkManagement {

	public static void main(String[] args) throws IOException {
		
		new Car().existingMembers();
		new Menu().switchMenu();
	}
	
	public void detectIncomingCars() {
		for (int i=0; i < 85; i++) {
			System.out.print("-");
		} 
		System.out.println(" ");
		System.out.println("                       INCOMING CARS STATUS               ");
		for (int i=0; i < 85; i++) {
			System.out.print("-");
		} 
		System.out.println(" ");
		//External sensors will detect an incoming cars
		String incomingCars []   = {"GJ1234", "G15599", "G17742"};
		//Internal sensors will detect where they are getting parked inside facilities
		String currentParkingposition [] = {"A3", "A2"};
		//Notified the system user about the status of incoming cars
	    int currentElement = 0;
	    for (int i = 0; i < incomingCars.length; i++) {
			//Sensor will be sending this license number as a parameter to check Car exists method
			if (new Car().checkCarexists(incomingCars[i]) == true) {
			//This car is getting park at its current position and system will push notification
				new Car().Parkingposition(currentParkingposition[i], incomingCars[i]);
				System.out.println(" ");
			}
	    }
	}
}
