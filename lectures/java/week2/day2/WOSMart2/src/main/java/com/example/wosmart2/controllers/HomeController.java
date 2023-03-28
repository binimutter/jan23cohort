package com.example.wosmart2.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("")
	public String index(HttpSession session) {
		session.setAttribute("name", "WOS Mart"); // This is hard coded so every time we load the index this will show for the User Name, but pet will change or be what ever was last put into the form (or empty if first run of app)
		return "index.jsp";
	}
	
	@PostMapping("/updateSession")
	public String updateSession(@RequestParam String name, @RequestParam String pet, Model model, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("pet", pet);
		
		return "redirect:/results";
	}
	@RequestMapping("/results")
	public String results() {
		return "results.jsp";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/results";
	}
}
