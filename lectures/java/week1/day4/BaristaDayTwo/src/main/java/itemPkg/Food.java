package itemPkg;

import interfaces.Temp;

public class Food extends Item implements Temp {
	//==========
	// ATTRIBUTES
	//==========
	private String flavor;
	private boolean glutenFree;
	
	//==========
	// CONSTRUCTOR
	//==========

	public Food(String name, double price, String flavor) {
		super(name, price);
		// TODO Auto-generated constructor stub
		this.flavor = flavor;
		this.glutenFree = false;
	}

	
	
	//==========
	//METHODS
	//==========
	
	public void displayItem() {
		super.displayItem();
		System.out.printf("\t%s is %s. Gluten Free is %s", this.getName(), this.flavor, this.glutenFree);
    }
	
	@Override
	public void hot() {
		// TODO Auto-generated method stub
		System.out.printf("%s is served hot", this.getName());
		
	}

	@Override
	public void cold() {
		// TODO Auto-generated method stub
		System.out.printf("%s is served warm", this.getName());
		
	}
	@Override
	public void warm() {
		// TODO Auto-generated method stub
		System.out.printf("%s is served cold", this.getName());
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

	public boolean isGlutenFree() {
		return glutenFree;
	}

	public void setGlutenFree(boolean glutenFree) {
		this.glutenFree = glutenFree;
	}




}
