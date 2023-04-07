package com.codingdojo.com.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.com.dojoandninjas.models.Dojo;
import com.codingdojo.com.dojoandninjas.models.Ninja;
import com.codingdojo.com.dojoandninjas.services.DojoServ;
import com.codingdojo.com.dojoandninjas.services.NinjaServ;

@Controller
public class HomeController {
	
	@Autowired
	private DojoServ dojoServ;
	
	@Autowired
	private NinjaServ ninjaServ;
	
//	GetMapping  - landing page (/)
	@GetMapping("/")
	public String index(@ModelAttribute("dojos") Dojo dojo, Model model) {
		model.addAttribute("allDojos", dojoServ.getAll());
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String addDojo(@ModelAttribute("dojoForm") Dojo dojo) {
		return "addDojo.jsp";
	}
	
	@PostMapping("/dojos/add")
	public String createDojo(@Valid @ModelAttribute("dojoForm") Dojo newDojo, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "addDojo.jsp";
		} else {
			dojoServ.createOne(newDojo);
			return "redirect:/";
		}
	}
	
	@GetMapping("/ninjas/new")
	public String addNinja(@ModelAttribute("ninjaForm") Ninja newNinja, Model model) {
		model.addAttribute("allDojos", dojoServ.getAll());
		return "addNinja.jsp";
	}
	
	@PostMapping("/ninjas/add")
	public String createNinja(@Valid @ModelAttribute("ninjaForm") Ninja newNinja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allNinjas", ninjaServ.getAll());
			return "addNinja.jsp";
		} else {
			ninjaServ.createOne(newNinja);
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojos/{dojo_id}")
	public String showDojo(@PathVariable("dojo_id") Long dojo_id, @ModelAttribute("dojo") Dojo dojo, Model model) {
		model.addAttribute("oneDojo", dojoServ.getOne(dojo_id));
		return "viewDojo.jsp";
	}

}
