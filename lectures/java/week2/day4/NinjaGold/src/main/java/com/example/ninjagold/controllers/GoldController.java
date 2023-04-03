package com.example.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoldController {
	
	
	@RequestMapping("/")
	public String index(HttpSession session) {
//		Creating count var setting to 0 to start us off
		int count = 0;

//		Creating the list for activites
		ArrayList<String> activities = new ArrayList<String>();
		
//		if statement to set session at begining for post logic
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", count);
			session.setAttribute("activity", activities);
			System.out.printf("%s from requestmapping\n", count);
		}
		return "index.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/gold/{place}")
	public String gold(HttpSession session, @PathVariable String place, Model model) {
//		get list from session
		
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activity");
		
//		getting current session value for count
		int count = (int) session.getAttribute("count");
		
//		Setting the date on activation of post
		String pattern = "MMM d Y h:m a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		
//		variable for randnumber
		int randNum = 0;
		
//		test print
		System.out.printf("%s from post before if, %s time before if\n", count, time);
		
		
		if(place.equals("farm")) {
			
//			creating the random number
			randNum = 10 + (int)(Math.random() * 10);
			
//			increasing count by randnumber
			count+= randNum;

			
//			adding string to activities list include date and rand number
			activities.add(0,"\nEntered Farm earned " + randNum + " gold. At " + time);
			

		}
		if(place.equals("cave")) {
			randNum = 5 + (int)(Math.random() * 5);
			count+= randNum;
			activities.add(0,"\nEntered Cave earned " + randNum + " gold. At " + time);
		}
		if(place.equals("house")) {
			randNum = 2 + (int)(Math.random() * 3);
			count+= randNum;
			activities.add(0,"\nEntered House earned " + randNum + " gold. At " + time);
		}
		if(place.equals("quest")) {
			randNum = 50 - (int)(Math.random() * 100);
			count+= randNum;
			if(randNum < 0) {
				activities.add(0,"\nEntered House lost " + -randNum + " gold. At " + time);
			} else {
				activities.add(0,"\nEntered House earned " + randNum + " gold. At " + time);
			}
		}
//		setting / updating activity session
		session.setAttribute("activity", activities);
//		updating count session 
		session.setAttribute("count", count);
		session.setAttribute("earned", randNum);
		return "redirect:/";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
