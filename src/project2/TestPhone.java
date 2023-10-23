package project2;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestPhone {

	public static void main(String[] args) {
		Phone p1 = new Phone("Sony", "Experia X", 32, 12.5, 3.6, "Yes", 150);
		Phone p2 = new Phone("Sony", "Experia Z", 64, 14.2, 5.6, "Yes" ,175);
		Phone p3 = new Phone("Samsung", "Galaxy M", 64, 14.5, 5.4, "Yes", 180);
		Phone p4 = new Phone("Nokia", "3330", 16, 13.2, 2.3, "No", 90);
		Phone p5 = new Phone("Motorola", "M1", 8, 11.3, 4.9, "Yes", 100);
		Phone p6 = new Phone("iPhone", "6", 32, 13.5, 6.4, "Yes", 250);
		Phone p7 = new Phone("Alcatel", "A3", 8, 9.3, 2.4, "No", 50);
		
		// Serialize
		try {
			// Serialize to the file
			FileOutputStream fileOut = new FileOutputStream("phone.ser");
			// Assign what object to serialize
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(p1);
			objOut.writeObject(p2);
			objOut.writeObject(p3);
			objOut.writeObject(p4);
			objOut.writeObject(p5);
			objOut.writeObject(p6);
			objOut.writeObject(p7);
			System.out.println("File serialized.");
		} catch (Exception e) {
			System.out.println("Exception cought.\n");
			e.printStackTrace();
		}
	}
}
