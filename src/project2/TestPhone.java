// A00279259 N.Palej

package project2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class TestPhone {

	public static void main(String[] args) {
		
		// Create array to store phones in
		List<Phone> phones = new ArrayList<>();
		
		// Add phones from the table
		phones.add(new Phone("Sony", "Experia X", 32, 12.5, 3.6, "Yes", 150));
		phones.add(new Phone("Sony", "Experia Z", 64, 14.2, 5.6, "Yes" ,175));
		phones.add(new Phone("Samsung", "Galaxy M", 64, 14.5, 5.4, "Yes", 180));
		phones.add(new Phone("Nokia", "3330", 16, 13.2, 2.3, "No", 90));
		phones.add(new Phone("Motorola", "M1", 8, 11.3, 4.9, "Yes", 100));
		phones.add(new Phone("iPhone", "6", 32, 13.5, 6.4, "Yes", 250));
		phones.add(new Phone("Alcatel", "A3", 8, 9.3, 2.4, "No", 50));
		
		try {
			serialisePhones(phones);
			System.out.println("Phones successfully serialised.\n");
		} catch (Exception e) {
			System.out.println("Couldn't serialize.\nError: ");
			e.printStackTrace();
		}
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------\n");
		
		// Deserializing
		System.out.println("Deserialised:\n");
		// Create list for deserialization 
		List<Phone> deserializedPhones = deserialisePhones();
		for (Phone phone : deserializedPhones) {
			System.out.println(phone.printDetails());
		}
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------\n");
		
		// Print message phone successfully deleted
		System.out.println("\nDeleting Alcatel... \n" + phones.remove(6).getMake() + " successfully deleted.");
		

		// Check if phone was deleted
		try {
			System.out.println(phones.get(6).getMake());
		} catch (Exception e) {
			System.out.println("\nChecking if phone still in table...\nPhone doens't exist in the table.");
		}
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------\n");
		
		// Add new phone to the list
		phones.add(new Phone("Huawei", "P30 Pro", 128, 14.5, 5.4, "Yes", 250));
		System.out.println("\nNew phone has been added: \n" + phones.get(6).printDetails());
	}
	
	// Serialise Method 
	public static void serialisePhones(List<Phone> phones) {
		
		try {
			// Serialise to the file
			FileOutputStream fileOut = new FileOutputStream("phone.ser");
			// Assign what object to serialise
			@SuppressWarnings("resource")
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			// Loop through phones array
			for (Phone p : phones) {
                objOut.writeObject(p);
            }
			objOut.close();
            fileOut.close();
		} catch (Exception e) {
			System.out.println("Exception cought.\n");
			e.printStackTrace();
		}
	}
	
	// Deserialise method
	public static List<Phone> deserialisePhones() {
		List<Phone> phones = new ArrayList<>();
		try {
			FileInputStream fileIn = new FileInputStream("phone.ser");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			
			// Loop until end of file is reached
			while (true) {
                try {
                    Phone p = (Phone) objIn.readObject();
                    phones.add(p);
                } catch (Exception e) {
                	//System.out.println("\n# End of File Reached#\n");
                    break; 
                }
            }
			objIn.close();
			fileIn.close();
		} catch (Exception e) {
			System.out.println("Couldn't deserialize the file!");
			e.printStackTrace();
		}
		return phones;
	}
}
