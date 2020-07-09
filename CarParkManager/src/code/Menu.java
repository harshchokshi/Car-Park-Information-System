package code;





public class Menu {
	static int selectedChoice;
	
	//List of Menu Option
	public void menuOptions () {
	System.out.println("\n"+"Select an option from the menu below");
	System.out.println("1. Register Car");
	System.out.println("2. Display Members");
	System.out.println("3. Monitor Incoming cars");
	System.out.println("4. Exit"+"\n");
	}
	
	public boolean systemExit() {
		System.out.println("-- Exiting Car Management System --\r\n" + 
				" ----\r\n" + 
				"-- Goodbye! -- ");
		return false;
	}
	
	public void switchMenu() {
		boolean switchOperator = true;
		while(switchOperator) {
		menuOptions();
		System.out.print("Enter your option: ");
		try {
			selectedChoice = Car.getScan.nextInt();
			System.out.println(" ");
			switch(selectedChoice) {
			case 1:
				new Car().registerMember();
				break;
			case 2:
				new Car().displayRegisterCars();
				break;
			case 3:
				new CarParkManagement().detectIncomingCars();
				break;
			case 4:
				System.out.println(" ");
				switchOperator = systemExit();;
				break;
		    default:
			    System.out.println("\n"+"Enter only number between 1 to 4.");
			    break;
		}
		} catch (Exception e) {
			System.out.println("\n"+"Unexpected input other than number. Try again !!!");
			Car.getScan.nextLine();
			
		}
	}
	}
}

