package classes;

import interfaces.Perishable;

public class Produce extends Item implements Perishable {

	//==========
	// Attributes
	//==========
	private double weight;
	
	//==========
	// Constructor
	//==========

	public Produce(String name, double price, double weight) {
		super(name, price);
		this.weight = weight;
	}

	
	//==========
	// Methods
	//==========
	
	public void printItem() {
		super.printItem();
		System.out.printf(" for %.2f oz", this.weight);
	}
	
	//==========
	// GETTERS & SETTERS
	//==========
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public void perishable() {
		// TODO Auto-generated method stub
		
	}
	
}
