package alphaversion;

/*
 * Usage of Java API
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * Class that interact with Car properties 
 */

public class ParkingLot {

	
	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static Scanner input = new Scanner(System.in);
	static Car cars = new Car();
	static List register = new ArrayList();
	static List checkIN = new ArrayList();
	static List checkOUT = new ArrayList();
	static List checkStatus = new ArrayList();

	/*
	 * Method that control buffer reader exception 
	 */
	public static void main(String[] args) throws Throwable {
		
		ParkingLot initiate = new ParkingLot();
		initiate.menu();

	}
    
	/*
	 * Satisfy fifth requirement of the program
	 */
	public void generateReport() {
		System.out.println("List of cars currently check IN");

		for (int i = 0; i < checkIN.size(); i++) {
			System.out.println(checkIN.get(i));

		}
	}
	
	/*
	 * Satisfy fourth requirement of the program
	 */

	private void checkOUT() {
		System.out.println("                   ");

		String customer;
		System.out.print("Enter number plate: ");
		customer = input.next();
		System.out.println(" ");

		if (!checkIN.contains(customer) && register.contains(customer)) {
			System.out.println("Update: Failure");
			System.out.println("Car is not check IN");
		}
		
		if (checkIN.contains(customer)) {
			checkOUT.add(customer);
			checkIN.remove(customer);
			System.out.println(customer + " successfully check OUT");
			System.out.println("    ");
		}
	
		if (!register.contains(customer)) {
			System.out.println("Update: Failure");
			System.out.println("Car is not register");
		}

		System.out.println("   ");
		System.out.print("Do you want to CHECK out another car?" + "\n"
				+ "Select Y or N: ");
		if (input.next().equalsIgnoreCase("Y")) {
			System.out.println("    ");
			checkOUT();

		}

	}
	
	/*
	 * Satisfy third requirement of the program
	 */

	private void checkIN() {
		do {
			System.out.println("                   ");
			String customer;
			System.out.print("Enter number plate: ");
			customer = input.next();
			System.out.println(" ");

			if (register.contains(customer)) {
				System.out.println(customer + " successfully check IN");
				checkIN.add(customer);
			} else {
				System.out.println("Failure to proceed" + "\n"
						+ "Car registration not found");

			}
			System.out.println("    ");
			System.out.print("Do you want to CHECK IN another car?" + "\n"
					+ "Select Y or N: ");
		} while (input.next().equalsIgnoreCase("Y"));

	}
	
	/*
	 * Satisfy second requirement of the program
	 */

	public void searchCar() {
		System.out.println("                   ");
		String customer;
		String status;
		System.out.print("Enter number plate: ");
		customer = input.next();
		System.out.println(" ");
		
		if ((!register.contains(customer))) {
			System.out.println("Please check the number again"+"\n"+"Seems that car is not register");
		    System.out.println("           ");
		    
		}
		
		
		
	
		
		
		if (checkOUT.contains(customer)){
			status = "checked OUT from parking lot";
			int i = register.indexOf(customer) - 1;
			do {

				System.out.println("Unique No: " + register.get(i));

				System.out.println("Number Plate: " + register.get(++i));

				System.out.println("Make: " + register.get(++i));

				System.out.println("Model: " + register.get(++i));

				System.out.println("Color: " + register.get(++i));

				System.out.println("Owner Name: " + register.get(++i));

				System.out.println("Owner Contact: " + register.get(++i));

				System.out.println("Status: " + status);

				System.out.println("                          ");
				System.out.println("                          ");

				i++;
			} while (i < 7);
		}
		if (checkIN.contains(customer)) {
			status = "checked IN in parking lot";

			int i = register.indexOf(customer) - 1;
			do {

				System.out.println("Unique No: " + register.get(i));

				System.out.println("Number Plate: " + register.get(++i));

				System.out.println("Make: " + register.get(++i));

				System.out.println("Model: " + register.get(++i));

				
				System.out.println("Color: " + register.get(++i));

				System.out.println("Owner Name: " + register.get(++i));

				System.out.println("Owner Contact: " + register.get(++i));

				System.out.println("Status: " + status);

				System.out.println("                          ");
				System.out.println("                          ");

				i++;
			} while (i < 7);
			
		} 
			
			if ((!checkIN.contains(customer) && !checkOUT.contains(customer))&& register.contains(customer)) {
				status = "Not checkIN in parking lot";
				int i = register.indexOf(customer) - 1;
				do {
					System.out.println("Unique No: " + register.get(i));

					System.out.println("Number Plate: " + register.get(++i));

					System.out.println("Make: " + register.get(++i));

					System.out.println("Model: " + register.get(++i));

					System.out.println("Color: " + register.get(++i));

					System.out.println("Owner Name: " + register.get(++i));

					System.out.println("Owner Contact: " + register.get(++i));

					System.out.println("Status: " + status);

					System.out.println("                          ");
					System.out.println("                          ");

					i++;
				} while (i < 7);
				
			}
			
		

		}
	
	/*
	 * Satisfy first requirement of the program
	 */

	

	public void registerCar() throws Exception {

		int uniqueID = 1;

		do {
			System.out.println("                   ");
			cars.setID(uniqueID);
			register.add(cars.getID());

			System.out.print("Enter number plate: ");
			cars.setNumberPlate(input.next());
			register.add(cars.getNumberPlate());

			System.out.print("Enter make: ");
			cars.setMake(input.next());
			register.add(cars.getMake());

			System.out.print("Enter model: ");
			cars.setModel(input.next());
			register.add(cars.getModel());

			System.out.print("Enter color: ");
			cars.setColor(input.next());
			register.add(cars.getColor());

			System.out.print("Enter owner name: ");
			cars.setOwnerName(in.readLine());
			register.add(cars.getOwnerName());

			System.out.print("Enter phone number: ");
			cars.setOwnerContact(input.next());
			register.add(cars.getOwnerContact());

			uniqueID++;

			System.out.println("    ");
			System.out.print("Do you want to register another car?" + "\n"
					+ "Select Y or N: ");

		} while (input.next().equalsIgnoreCase("Y"));
		System.out.println("                   ");

	}

	// Switch operated Menu
	public void menu() throws Throwable {
		// Control switch
		boolean quit = false;
		boolean condition = true;
		// Selector
		int menuItem;

		// Menu Options
		while (condition) {
			try {

				do {
					System.out.println("    ");
					System.out.println("1. Register a new car");
					System.out.println("2. Search all cars");
					System.out.println("3. Check a car in");
					System.out.println("4. Check a car out");
					System.out.println("5. Check in report");
					System.out.println("6. Exit");
					System.out.println(" ");
					System.out.print("Choose menu item: ");
					menuItem = input.nextInt();
					System.out.println("    ");
					// Select switch
					switch (menuItem) {
					case 1:
						// Invoke Method
						registerCar();

						break;
					case 2:
						// Invoke Method
						do {
							searchCar();
							System.out.println("    ");
							System.out
									.print("Do you want to search another car?"
											+ "\n" + "Select Y or N: ");
						} while (input.next().equalsIgnoreCase("Y"));

						break;
					case 3:
						checkIN();

						break;
					case 4:
						checkOUT();

						break;
					case 5:
						generateReport();
						
						break;
					case 6:
						// Assign variable to close the loop
						quit = true;
						break;
					default:
						// Any other choice make apart from number of given
						// options
						System.out.println("Invalid choice.");
					}
				} while (!quit);

				System.out.println("Program shutting down...");
				condition = false;

			} catch (InputMismatchException e) {

				System.err.println("Entered value is not an integer");

				input.nextLine();

			}
		}

	}
}
