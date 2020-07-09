package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;



public class Car {
	
	private String licencePlate;
	private String appartmentNum;
	private String ownerName;
	private String parkingSlot;
	private static ArrayList<Car> Cars = new ArrayList<Car>();
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static Scanner getScan = new Scanner (System.in);
	
	
	public Car(String licencePlate, String appartmentNum, String ownerName, String parkingSlot) {
		super();
		this.licencePlate = licencePlate;
		this.appartmentNum = appartmentNum;
		this.ownerName = ownerName;
		this.parkingSlot = parkingSlot;
	}
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public String getLicencePlate() {
		return licencePlate;
	}
	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}
	public String getAppartmentNum() {
		return appartmentNum;
	}
	public void setAppartmentNum(String appartmentNum) {
		this.appartmentNum = appartmentNum;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getParkingSlot() {
		return parkingSlot;
	}
	public void setParkingSlot(String parkingSlot) {
		this.parkingSlot = parkingSlot;
	}
	public static ArrayList<Car> getCars() {
		return Cars;
	}
	public static void setCars(ArrayList<Car> cars) {
		Cars = cars;
	}
	
	

	@Override
	public String toString() {
		//return "Car [getLicencePlate()=" + getLicencePlate() + ", getAppartmentNum()=" + getAppartmentNum()
				//+ ", getOwnerName()=" + getOwnerName() + ", getParkingSlot()=" + getParkingSlot() + "]";
		
		//return	String.format("%-5s %-5s %-5s %-2s %-5s %-5s %-5s %-5s\n", "Licence Number:",  getLicencePlate(), "Parking Slot:", getParkingSlot(),"Owner Name:",  getOwnerName(), "Appartment:", getAppartmentNum());
		return String.format("%10s %15s %25s %15s %n", getLicencePlate() ,  getParkingSlot(), getOwnerName(),  getAppartmentNum());		
	}
	public String licencePlate() throws IOException {
		String licencePlate;
		boolean notValid = true;
		do {
			System.out.print("Enter the car license number: ");
			 licencePlate = in.readLine();
			if ( licencePlate.matches("[a-zA-Z]+[0-9]+")==true ) {
				notValid = false;
			} else {
				notValid = true;
				System.out.println("Alphabet in the beginning and then number no special character. Try again...");
			}
		} while(notValid);

		return  licencePlate;
		}
	
	public String appartmentNum() throws IOException {
		String appartmentNum;
		boolean notValid = true;
		do {
			System.out.print("Enter the appartment number: ");
			 appartmentNum = in.readLine();
			if ( appartmentNum.matches("[a-zA-Z]+[0-9]+")==true ) {
				notValid = false;
			} else {
				notValid = true;
				System.out.println("Alphabet in the beginning and then number no special character. Try again...");
			}
		} while(notValid);

		return   appartmentNum;
		}
	
	
	public String ownerName() throws IOException {
		String name;
		do {
			System.out.print("Enter the name of the owner: ");
			name = in.readLine();
			if (name.matches(("[a-zA-Z][a-zA-Z ]+[a-zA-Z]$"))==false) {
				System.out.println("Try again !!! Only alphabets no special character or numbers");
				continue;
			}
			else {
				break;
			}
		} while(true);

		return name;
	}
	
	public String parkingSlot() throws IOException {
		String parkingSlot;
		boolean notValid = true;
		do {
			System.out.print("Allocate parking place: ");
			parkingSlot = in.readLine();
			if (parkingSlot.matches("[a-zA-Z]+[0-9]+")==true ) {
				notValid = false;
			} else {
				notValid = true;
				System.out.println("Alphabet in the beginning and then number no special character. Try again...");
			}
		} while(notValid);

		return parkingSlot;
		}
	
	public void existingMembers() {
		getCars().add(new Car("GJ1234","A1", "Kanikaa Kapoor ", "A11"));
		getCars().add(new Car("G15599","A1", "Karishma Kapoor", "A12"));
		getCars().add(new Car("G17743","A2", "Alia Bhatt", "A21"));

	}
	
	public void displayRegisterCars() {
		
		for (int i=0; i < 85; i++) {
			System.out.print("-");
		} 
		System.out.println(" ");
		System.out.println("                       REGISTER CAR PARK MEMBERS             ");
		System.out.println(" ");
		System.out.printf( "%10s %15s %20s %20s %n", "Licence Number", "Parking Slot", "Owner Name", "Appartment Number" );
		for (int i=0; i < 85; i++) {
			System.out.print("-");
		} 
		System.out.println(" ");
		for (Car cars : getCars()) {
			System.out.println(cars.toString());
		}
	}
	
	public boolean checkCarexists(String detectedPlate) {
		int count = 0;
		int currentElement = 0;
		for (Car cars : getCars()) {
			if (detectedPlate.equals(cars.getLicencePlate())) {
				count++;
			}
			else {
				currentElement++;
			}
		}
		if (count > 0) {
			System.out.println(detectedPlate+" is a registered car and allowed to park.");
			return true;
		}
		else {
			System.out.println("Sorry "+detectedPlate+" is member of this car park and boom barrier will remain closed.");
			return false;
		}
		
	}
	
	public boolean Parkingposition(String currentParkingPosition, String detectedPlate) {
		int count = 0;
		int currentElement = 0;
		String correctSpot="II";
		for (Car cars : getCars()) {
			if (currentParkingPosition.equals(cars.getParkingSlot()) && detectedPlate.equals(cars.getLicencePlate())) {
				count++;
			}
			if (detectedPlate.equals(cars.getLicencePlate())) {
				correctSpot = cars.getParkingSlot();
			}
			else {
				currentElement++;
			}
		}
		if (count > 0) {
			System.out.println(detectedPlate+ " is getting park at right place");
			return true;
		}
		else {
			System.out.println(detectedPlate+ " is getting park at wrong place. Driver please park at your registered spot "+correctSpot);
			return false;
		}
		
	}
	
	
		
		public void addMember() throws IOException {
			
			do {
			getCars().add(new Car(licencePlate(),appartmentNum(), ownerName(), parkingSlot()));
			char pressKey;
			System.out.println("\n"+"Would you like to [R] / [r]dd another member or continue [M] / [m]onitoring car park?"+"\n");
			try {
				pressKey = getScan.next(".").charAt(0);
				if (pressKey!='R' && pressKey != 'r' && pressKey !='m' && pressKey !='M') {
					System.out.println("Invalid response !!!");
					continue;
				}
				else if (pressKey == 'R' || pressKey == 'r') {
					System.out.println(" ");
					continue;
				}
				else {
					break;
				}
			} catch (Exception e) {
				System.out.println("Invalid response !!!");
				getScan.nextLine();
				continue;
			}
			
			} while (true);
		}
		
		public void registerMember() throws IOException {
			char pressKey;
			do {
				getCars().add(new Car(licencePlate(),appartmentNum(), ownerName(), parkingSlot()));
				System.out.println("\n"+"Would you like to [R] / [r]dd another member or continue [M] / [m]onitoring car park?"+"\n");
				try {
					pressKey = getScan.next(".").charAt(0);
					if (pressKey!='R' && pressKey != 'r' && pressKey !='m' && pressKey !='M') {
						System.out.println("Invalid response !!!");
						continue;
					}
					else if (pressKey == 'R' || pressKey == 'r') {
						System.out.println(" ");
						continue;
					}
					else {
						break;
					}
				} catch (Exception e) {
					System.out.println("Invalid response !!!");
					getScan.nextLine();
					continue;
				}
			} while(true);
		}
}
	

