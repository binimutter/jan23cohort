package com.example.flashsession.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/submit")
	public String submit(@RequestParam String petName, @RequestParam int petAge, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		session.setAttribute("petName", petName);
		session.setAttribute("petAge", petAge);
		redirectAttributes.addFlashAttribute("session", "Session has been updated");
		return "redirect:/";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("session", "Session has been cleared");
		return "redirect:/";
	}
}
