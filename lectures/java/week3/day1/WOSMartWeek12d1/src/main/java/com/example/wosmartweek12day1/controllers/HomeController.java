package com.example.wosmartweek12day1.controllers;

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

import com.example.wosmartweek12day1.models.Item;
import com.example.wosmartweek12day1.services.ItemServ;

@Controller
public class HomeController {

	@Autowired
	private ItemServ itemServ;

//	Main Landing Page
	@GetMapping("/")
	public String index(@ModelAttribute("item") Item item, Model model) {
		model.addAttribute("allItems", itemServ.allItems());
		
		return "index.jsp";
	}
	
//	Add Item Form
	@GetMapping("/addItem")
	public String addItem(@ModelAttribute("itemForm") Item item) {
		
		return "addItem.jsp";
	}
	
//	Creating Item
	@PostMapping("/createItem")
	public String createItem(@Valid @ModelAttribute("itemForm") Item newItem, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "addItems.jsp";
		} else {
			itemServ.createItem(newItem);
			return "redirect:/";
		}
	}
	
//	Edit item page
	@GetMapping("/item/{id}/edit")
	public String editItem(@PathVariable("id") Long id, @ModelAttribute("itemEditForm") Item item, Model model) {
		
		model.addAttribute("item", itemServ.getOne(id));
		
		return "editItem.jsp";
	}
	
//	Update item
	@PutMapping("/item/{id}/update")
	public String updateItem(@PathVariable("id") Long id, @Valid @ModelAttribute("itemEditForm") Item item, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "editItem.jsp";
		} else {
			itemServ.updateItem(item);
			return "redirect:/";
		}
	}
	
//	View 1 item page
	
//	Delete 1 item
	@GetMapping("/item/{id}/delete")
	public String deleteItem(@PathVariable("id") Long id) {
		itemServ.deleteOne(id);
		return "redirect:/";
	}
}
