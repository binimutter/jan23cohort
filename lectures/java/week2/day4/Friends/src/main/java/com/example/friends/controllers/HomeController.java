package com.example.friends.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.friends.models.Friend;
import com.example.friends.services.FriendServ;

@Controller
public class HomeController {

	public final FriendServ friendServ;
	
	public HomeController(FriendServ friendServ) {
		this.friendServ = friendServ;
	}
	
	@GetMapping("/")
	public String index(Model model, @ModelAttribute("friend") Friend friend) {
		List<Friend> friends = friendServ.allFriends();
		
		model.addAttribute("viewFriends", friends);
		
		return "index.jsp";
	}
	@PostMapping("/addFriend")
	public String addFriend(@Valid @ModelAttribute("friend") Friend friend, BindingResult result, Model model) {
		
        if (result.hasErrors()) {
	        	List<Friend> friends = friendServ.allFriends();
	    		
	    		model.addAttribute("viewFriends", friends);
        		
            return "index.jsp";
        } else {
            friendServ.createFriend(friend);
            return "redirect:/";
        }
	}
}
