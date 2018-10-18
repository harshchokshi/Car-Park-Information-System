package alphaversion;


public class Car {
	
	    //Car properties
		private int ID = 0;
		private String numberPlate;
		private String make;
		private String model;
		private String color;
		private String ownerName;
		private String ownerContact;
	
	
        /*
         Return value of properties
         */
		public int getID() {
			return ID;
		}
		
		public String getNumberPlate() {
			return numberPlate;
		}
		
		public String getMake() {
			return make;
		}
		
		public String getColor() {
			return color;
		}
		
		public String getModel() {
			return model;
		}
		
		public String getOwnerName() {
			return ownerName;
		}
		
		public String getOwnerContact() {
			return ownerContact;
		}
		
        /*
        Set the properties value transported from constructor arguments
        */


		public void setID(int iD) {
			ID = iD;
		}

	

		public void setNumberPlate(String numberPlate) {
			this.numberPlate = numberPlate;
		}

	

		public void setMake(String make) {
			this.make = make;
		}

	

		public void setModel(String model) {
			this.model = model;
		}

	

		public void setColor(String color) {
			this.color = color;
		}


		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}

		

		public void setOwnerContact(String ownerContact) {
			this.ownerContact = ownerContact;
		}
		
		/*
		 * Class parameterized constructor
		 */

		
		public Car(int iD, String numberPlate, String make, String model,
				String color, String ownerName, String ownerContact) {
			super();
			ID = iD;
			this.numberPlate = numberPlate;
			this.make = make;
			this.model = model;
			this.color = color;
			this.ownerName = ownerName;
			this.ownerContact = ownerContact;
		}
		
		/*
		 * Class default constructor
		 */
		
		public Car ( ) {
			
		
			
		}
		
		/*
		 * Mandatory method to obtain program functionality
		 */

		@Override
		public String toString() {
			return "Car [ID=" + ID + ", numberPlate=" + numberPlate + ", make="
					+ make + ", model=" + model + ", color=" + color
					+ ", ownerName=" + ownerName + ", ownerContact="
					+ ownerContact + "]";
		}
		
		



	
	

	
}
