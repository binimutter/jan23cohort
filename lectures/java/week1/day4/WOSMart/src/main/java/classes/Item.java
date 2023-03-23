package classes;

import java.util.ArrayList;

public class Item {
	
	
	public static ArrayList<Item> allItems = new ArrayList<>();
	
	//==========
	// Attributes
	//==========
	
	private String name;
	private double price;
	
	//==========
	// Constructor
	//==========

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	
	//==========
	// Methods
	//==========
	public void printItem() {
		System.out.printf("\t%s $%.2f", this.name, this.price);
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


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
