package com.codingdojo.com.baristaschallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BaristasChallengeApplication {
	public static void main(String[] args) {

		//	=== Initial Test ===
		Item item01 = new Item("Large Coffee", 2.75);
//		System.out.println(item01);
//		System.out.printf("\t%s %.2f\n", item01.getName(), item01.getPrice());
		item01.displayItem();
		
		
		Order dana = new Order("Dana");
//		dana.setItem(item01);
		dana.addItem(item01);
		dana.addItem(item01);
		dana.displayOrder();
		

		/**
		 * @author HoneyBee
		 * All functions will appear above this line
		 */
		SpringApplication.run(BaristasChallengeApplication.class, args);
	}

}
