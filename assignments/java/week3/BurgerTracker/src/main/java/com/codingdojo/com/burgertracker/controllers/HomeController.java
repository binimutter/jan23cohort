package com.codingdojo.com.burgertracker.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.com.burgertracker.models.Burger;
import com.codingdojo.com.burgertracker.services.BurgerServ;

@Controller
public class HomeController {
	
	
	@Autowired
	private BurgerServ burgerServ;
	
//	Main Landing Page AND Add Burger Form
	@GetMapping("/")
	public String index(@ModelAttribute("burger") Burger burger, Model model) {
		model.addAttribute("allBurgers", burgerServ.allBurgers());
		
		return "index.jsp";
	}
	
//	Creating Burger
	@PostMapping("/burger/create")
	public String create(@Valid @ModelAttribute("burger") Burger newBurger, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			burgerServ.create(newBurger);
			return "redirect:/";
		}
	}
	
//	Edit Burger Page
	@GetMapping("/burger/{id}/edit")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("burgerEditForm") Burger burger, Model model) {
		model.addAttribute("burger", burgerServ.getOne(id));
		return "editBurger.jsp";
	}
	
//	Update Burger
	@PutMapping("/burger/{id}/update")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("burgerEditForm") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editBurger.jsp";
		} else {
			burgerServ.update(burger);
			return "redirect:/";
		}
	}
	
//	Delete 1 Item
	@GetMapping("/burger/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		burgerServ.deleteOne(id);
		return "redirect:/";
	}
}

