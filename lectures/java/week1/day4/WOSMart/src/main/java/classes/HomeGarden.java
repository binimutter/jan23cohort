package classes;

import interfaces.Season;

public class HomeGarden extends Item implements Season {
	
	//==========
	// Attributes
	//==========
	private String section;

	//==========
	// Constructor
	//==========

	public HomeGarden(String name, double price, String section) {
		super(name, price);
		this.section = section;
	}
	
	//==========
	// Methods
	//==========
	
	public void printItem() {
		super.printItem();
		System.out.printf(" from the %s seciton", this.section);
	}
	
	//==========
	// GETTERS & SETTERS
	//==========

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public void season() {
		// TODO Auto-generated method stub
		
	}
	
	
}
