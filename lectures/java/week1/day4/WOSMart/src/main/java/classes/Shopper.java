package classes;

import java.util.ArrayList;

public class Shopper {
	
	//==========
	// Attributes
	//==========
	private String name;
	private double total;
//	private int itemQuantity;
	private int cartQuantity;
	private ArrayList<Item> items;
	
	
	//==========
	// Constructor
	//==========

	public Shopper(String name) {
		this.name = name;
		this.total = 0.00;
//		this.itemQuantity = 1;
		this.cartQuantity = 0;
		this.items = new ArrayList<>();
	}

	
	//==========
	// Methods
	//==========
	public void welcomeShopper() {
		System.out.printf("\nWelcome shopper %s, glad you are here", this.name);
	}
	
	public Item addItems(Item newItem) {
		this.items.add(newItem);
		this.total += newItem.getPrice();
		this.cartQuantity += 1;
//		if(items.contains(newItem)) {
//			this.itemQuantity += 1;
//		}
		return newItem;
	}
	
	public void printCart() {
		System.out.printf("\n%s your cart contains the following items:", this.name);
		for(Item i : items) {
			i.printItem();
		}
		System.out.printf("\nYou have %d items in your cart for a total of $%.2f", this.cartQuantity, this.total);
	}
	
	
	//==========
	// GETTERS & SETTERS
	//==========
//	public int getItemQuantity() {
//		return itemQuantity;
//	}
//
//
//	public void setItemQuantity(int itemQuantity) {
//		this.itemQuantity = itemQuantity;
//	}


	public int getCartQuantity() {
		return cartQuantity;
	}


	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Item> getItems() {
		return items;
	}


	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
}
