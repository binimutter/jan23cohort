package com.codingdojo.com.daikichi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/daikichi")
public class HomeController {

	@RequestMapping("/travel/{city}")
	public String travel(@PathVariable String city, Model model) {
		model.addAttribute("city", city);
		
		return "index.jsp";
	}
	
	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable Integer num, Model model) {
		model.addAttribute("num", num);
		
		return "lotto.jsp";
	}
}
