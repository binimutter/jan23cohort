package com.vdh.ContactProject.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vdh.ContactProject.models.Contact;
import com.vdh.ContactProject.services.ContactService;

@Controller
public class HomeController {
	
//	========
//	FIELD
//	========
	private final ContactService contactService;
	
	
//	========
//	CONSTRUCTOR
//	========
	public HomeController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		
//		Getting all contacts
		List<Contact> contacts = contactService.allContacts();
//		bring info to jsp
		model.addAttribute("viewContacts", contacts);
		
		
		return "index.jsp";
	}
}
