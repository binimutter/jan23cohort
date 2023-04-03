package com.example.images.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.images.models.Image;
import com.example.images.services.ImageServ;

@Controller
public class ImageController {
//	private final ImageServ imageServ;
//	
//	public ImageController(ImageServ imageServ) {
//		this.imageServ = imageServ;
//	}
	
//	The below autowrired replaces the above 4 lines of code
	
	@Autowired
	private ImageServ imageServ;
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("image") Image image) {
		List<Image> images = imageServ.allImages();
		
		model.addAttribute("viewImages", images);
		
		return "index.jsp";
	}
	@PostMapping("/createImg")
	public String createImg(@Valid @ModelAttribute("image") Image image, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Image> images = imageServ.allImages();
			model.addAttribute("viewImages", images);
			return "index.jsp";
		} else {
			imageServ.createImage(image);
			return "redirect:/";
		}
	}
}
