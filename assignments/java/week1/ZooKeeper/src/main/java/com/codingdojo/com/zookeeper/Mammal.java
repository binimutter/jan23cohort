package com.codingdojo.com.zookeeper;

public class Mammal {
	protected int energyLevel;
	protected String name;
	
	//==========
	// CONSTRUCTOR
	//==========
	
	public Mammal(String name) {
		this.name = name;
		this.energyLevel = 100;
	}

	
	//==========
	// METHODS
	//==========
	
	public void displayEnergy() {
		System.out.printf("%s's Energy Level: %d\n", this.name, energyLevel);
	}
	
	//==========
	// GETTERS & SETTERS
	//==========
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
