package itemPkg;

import java.util.ArrayList;

public abstract class Item {
	
	public static ArrayList<Item> menu = new ArrayList<>();
	
	//==========
	// ATTRIBUTES
	//==========
	private String name;
	private double price;
	
	
	//==========
	// CONTRUCTOR
	//==========
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	//==========
	// METHODS
	//==========

	public Item addFood(Food newFood) {
		Item.menu.add(newFood);
		return newFood;
	}
	public Item addDrink(Drink newDrink) {
		Item.menu.add(newDrink);
		return newDrink;
	}
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
