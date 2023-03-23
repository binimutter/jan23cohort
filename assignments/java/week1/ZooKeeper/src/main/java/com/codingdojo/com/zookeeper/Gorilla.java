package com.codingdojo.com.zookeeper;

public class Gorilla extends Mammal{

	//==========
	// ATTRIBUTES
	//==========
	
	//==========
	// CONSTRUCTOR
	//==========

	public Gorilla(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	
	//==========
	// METHODS
	//==========
	
	public void throwThings() {
		this.energyLevel -= 5;
		System.out.printf("%s just threw something! %s's energy level is now %d.\n", this.name, this.name, this.energyLevel);
	}
	
	public void eatBananas() {
		this.energyLevel += 10;
		System.out.printf("%s ate a banana and is satisfied! %s's energy level is now %d.\n", this.name, this.name, this.energyLevel);
	}
	
	public void climb() {
		this.energyLevel -= 10;
		System.out.printf("%s has climbed a tree! %s's energy level is now %d.\n", this.name, this.name, this.energyLevel);
	}
	
	
	//==========
	// GETTERS & SETTERS
	//==========
	

}
