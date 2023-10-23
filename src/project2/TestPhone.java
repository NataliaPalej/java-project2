package project2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.List;

public class TestPhone {
	
//	static ArrayList<Phone> phoneList = new ArrayList<>();

	public static void main(String[] args) {
		
		Phone p1 = new Phone("Sony", "Experia X", 32, 12.5, 3.6, "Yes", 150);
		Phone p2 = new Phone("Sony", "Experia Z", 64, 14.2, 5.6, "Yes" ,175);
		Phone p3 = new Phone("Samsung", "Galaxy M", 64, 14.5, 5.4, "Yes", 180);
		Phone p4 = new Phone("Nokia", "3330", 16, 13.2, 2.3, "No", 90);
		Phone p5 = new Phone("Motorola", "M1", 8, 11.3, 4.9, "Yes", 100);
		Phone p6 = new Phone("iPhone", "6", 32, 13.5, 6.4, "Yes", 250);
		Phone p7 = new Phone("Alcatel", "A3", 8, 9.3, 2.4, "No", 50);
		
//		phoneList.add(p1);
//		phoneList.add(p2);
//		phoneList.add(p3);
//		phoneList.add(p4);
//		phoneList.add(p5);
//		phoneList.add(p6);
//		phoneList.add(p7);
		
//		System.out.println("Amount of items in array: " + phoneList.size());
//		System.out.println();
		
		// Serialize
		try {
			// Serialize to the file
			FileOutputStream fileOut = new FileOutputStream("phone.ser");
			// Assign what object to serialize
			@SuppressWarnings("resource")
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(p1);
			objOut.writeObject(p2);
			objOut.writeObject(p3);
			objOut.writeObject(p4);
			objOut.writeObject(p5);
			objOut.writeObject(p6);
			objOut.writeObject(p7);
			
			System.out.println("SERIALIZED:\n\n" + p1.printDetails() + "\n" + p2.printDetails() + "\n" + p3.printDetails() + "\n" + 
								p4.printDetails() + "\n" + p5.printDetails() + "\n" + p6.printDetails() + "\n" +  p7.printDetails() );
			
			Phone p8 = new Phone("Huawei", "P30 Pro", 128, 14.5, 5.4, "Yes", 200);
			System.out.println("\nNew phone added: \n" + p8.printDetails());
			objOut.writeObject(p8);
			System.out.println("\nNew phone serialized: " + p8.getMake());
		} catch (Exception e) {
			System.out.println("Exception cought.\n");
			e.printStackTrace();
		}
		
		System.out.println("\n--------------------------------------------------------------------------------------------------------------------\n");
		
		// Deserialize
		try {
			FileInputStream fileIn = new FileInputStream("phone.ser");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			Phone phone1 = (Phone)objIn.readObject();
			Phone phone2 = (Phone)objIn.readObject();
			Phone phone3 = (Phone)objIn.readObject();
			Phone phone4 = (Phone)objIn.readObject();
			Phone phone5 = (Phone)objIn.readObject();
			Phone phone6 = (Phone)objIn.readObject();
			Phone phone7 = (Phone)objIn.readObject();
			
			System.out.println("DESERIALIZED:\n\n" + phone1.printDetails() + "\n" + phone2.printDetails() 
								+ "\n" + phone3.printDetails() + "\n" + phone4.printDetails() + "\n" + phone5.printDetails() 
								+ "\n" + phone6.printDetails() + "\n" + phone7.printDetails());
			
			Phone phone8 = (Phone)objIn.readObject();
			System.out.println("\nDESERIALIZING NEWLY ADDED PHONE:");
			System.out.println(phone8.printDetails());
			
			
			objIn.close();
			fileIn.close();
		} catch (Exception e) {
			System.out.println("Couldn't deserialize the file!");
		}
	}
}
