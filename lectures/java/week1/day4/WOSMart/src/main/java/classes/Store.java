package classes;

import java.util.ArrayList;

public class Store {
	
	//==========
	// Attributes
	//==========
	private String name;
	private String location;
	private int storeNumber;
	private ArrayList<Shopper> shoppers;
	
	//==========
	// Constructor
	//==========
	
	public Store(String name, String location, int storeNumber) {
		this.name = name;
		this.location = location;
		this.storeNumber = storeNumber;
		this.shoppers = new ArrayList<>();
	}
	
	//==========
	// Methods
	//==========
	
	public void selfCheckout() {
		System.out.printf("welcome to self checkout, you will regret this!");
	}
	public void storeInfo() {
		System.out.printf("\nWelcome to %s, located at %s.", this.name, this.location);
	}
	
	//==========
	// GETTERS & SETTERS
	//==========

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}

	public ArrayList<Shopper> getShoppers() {
		return shoppers;
	}

	public void setShoppers(ArrayList<Shopper> shoppers) {
		this.shoppers = shoppers;
	}
	
	
	
}
