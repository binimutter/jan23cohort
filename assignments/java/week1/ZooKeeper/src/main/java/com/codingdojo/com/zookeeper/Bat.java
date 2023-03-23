package com.codingdojo.com.zookeeper;

public class Bat extends Mammal{

	
	//==========
	// ATTRIBUTES
	//==========
	
	//==========
	// CONSTRUCTOR
	//==========

	public Bat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.energyLevel = 300;
	}
	
	//==========
	// METHODS
	//==========
	
	public void fly() {
		this.energyLevel -= 50;
		System.out.printf("flap flap screech flap! %s's energy level is now %d.\n", this.name, this.energyLevel);
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.printf("um.. %s's energy level is now %d.\n", this.name, this.energyLevel);
	}
	
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.printf("*sound of a town on fire* %s's energy level is now %d.\n", this.name, this.energyLevel);
	}
	
	//==========
	// GETTERS & SETTERS
	//==========
	

}
