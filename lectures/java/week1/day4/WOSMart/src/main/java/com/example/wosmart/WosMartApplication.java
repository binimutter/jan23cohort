package com.example.wosmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import classes.Clothing;
import classes.HomeGarden;
import classes.Produce;
import classes.Shopper;
import classes.Store;

@SpringBootApplication
public class WosMartApplication {

	public static void main(String[] args) {
		
		Store wos = new Store("WOS Mart", "Zoom Classroom", 1);
		wos.storeInfo();
		Produce acaiBowl = new Produce("Acai Bowl", 10, 3);
		Clothing womensTop =  new Clothing("Tank Top", 5.95, "Womens", 22);
		HomeGarden tree = new HomeGarden("Cherry Tree", 10.89, "Garden Center");
		
		Shopper jane = new Shopper("Jane");
		jane.addItems(tree);
		jane.addItems(acaiBowl);
		jane.addItems(womensTop);
		jane.welcomeShopper();
		jane.printCart();
		
		
		
		
		
		SpringApplication.run(WosMartApplication.class, args);
	}

}
