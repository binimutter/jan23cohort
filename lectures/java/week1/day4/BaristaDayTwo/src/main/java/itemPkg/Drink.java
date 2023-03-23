package itemPkg;

import interfaces.Temp;

public class Drink extends Item implements Temp {
	
	//==========
	// Drink Attributes
	//==========
	private String flavor;
	private String size;
	
	//==========
	// Constructor
	//==========
	public Drink(String name, double price, String flavor, String size) {
		super(name, price);
		// TODO Auto-generated constructor stub
		this.flavor = flavor;
		this.size = size;
		
	}
	//==========
	// Methods
	//==========
	
	public void displayItem() {
		super.displayItem();
		System.out.printf("\t%s %s is %s flavored", this.size, this.getName(), this.flavor);
    }
	@Override
	public void hot() {
		// TODO Auto-generated method stub
		System.out.printf("\t%s is served hot, please drink carefully", this.getName());
		
	}

	@Override
	public void cold() {
		// TODO Auto-generated method stub
		System.out.printf("\t%s is served warm, feel free to drink away", this.getName());
		
	}
	@Override
	public void warm() {
		// TODO Auto-generated method stub
		System.out.printf("\t%s is served cold, drink slowy in case of brian freeze", this.getName());
	}

	
	//==========
	// GETTERS & SETTERS
	//==========
	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


}
