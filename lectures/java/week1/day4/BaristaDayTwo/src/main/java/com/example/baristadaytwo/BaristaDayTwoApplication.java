package com.example.baristadaytwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import itemPkg.Drink;
import itemPkg.Food;
import itemPkg.Order;

@SpringBootApplication
public class BaristaDayTwoApplication {

	public static void main(String[] args) {
		Food bagel = new Food("Bagel", 3.75, "Plain");
		Drink frap = new Drink("Frappuccino", 5.89, "Vanilla", "Lg");
		
		bagel.addFood(bagel);
		bagel.displayItem();
		frap.addDrink(frap);
		frap.displayItem();
		
		Order sierra = new Order("Sierra");
		sierra.addItem(frap);
		frap.cold();
		bagel.warm();
		sierra.addItem(bagel);
		
		
		SpringApplication.run(BaristaDayTwoApplication.class, args);
	}

}
