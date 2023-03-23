package com.codingdojo.com.baristaschallenge;

public class Item {
	private String name;
	private double price;
	
	
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	
	//==========
	// METHODS
	//==========
	
	public void displayItem() {
		System.out.printf("\t%s %.2f\n", this.name, this.price);
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
