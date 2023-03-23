package classes;

import interfaces.Season;

public class Clothing extends Item implements Season {
	
	//==========
	// Attributes
	//==========
	private String category;
	private int size;
	
	//==========
	// Constructor
	//==========

	public Clothing(String name, double price, String category, int size) {
		super(name, price);
		this.category = category;
		this.size = size;
	}
	
	//==========
	// Methods
	//==========
	public void printItem() {
		super.printItem();
		System.out.printf(" %d size from the %s department ", this.size, this.category);
	}
	
	//==========
	// GETTERS & SETTERS
	//==========

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void season() {
		// TODO Auto-generated method stub
		
	}
	
	
}
