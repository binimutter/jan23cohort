package itemPkg;

import java.util.ArrayList;

public class Order {
	
	//==========
	// Attributes
	//==========
	private String name;
	private double total;
	private boolean ready;
	private ArrayList<Item> items;

	
	//==========
	// Constructor
	//==========
	public Order(String name) {
		super();
		this.name = name;
		this.total = 0.00;
		this.ready = false;
		this.items = new ArrayList<>();
	}
	
	//==========
	// Methods
	//==========
	public Item addItem(Item newItem) {
		this.items.add(newItem);
		this.total += newItem.getPrice();
		return newItem;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
}
