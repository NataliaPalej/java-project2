package project2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Phone implements Serializable {
	
	// Declare variables
	private String make, model, smart;
	private double camera, screen, price;
	private int memory;
	
	// Constructor
	public Phone(String make, String model, int memory, double camera, double screen, String smart, double price) {
		this.make = make;
		this.model = model;
		this.memory = memory;
		this.camera = camera;
		this.screen = screen;
		this.smart = smart;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getCamera() {
		return camera;
	}

	public void setCamera(double camera) {
		this.camera = camera;
	}

	public double getScreen() {
		return screen;
	}

	public void setScreen(double screen) {
		this.screen = screen;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String isSmart() {
		return smart;
	}

	public void setSmart(String smart) {
		this.smart = smart;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}
}
