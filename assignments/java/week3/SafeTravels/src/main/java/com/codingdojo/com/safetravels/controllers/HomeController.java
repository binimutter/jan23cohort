package com.codingdojo.com.safetravels.controllers;

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

import com.codingdojo.com.safetravels.models.Expense;
import com.codingdojo.com.safetravels.services.ExpenseServ;

@Controller
public class HomeController {

	@Autowired
	private ExpenseServ expenseServ;
	
	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("allExpenses", expenseServ.getAll());
		
		return "index.jsp";
	}
	
	@PostMapping("/expense/create")
	public String create(@Valid @ModelAttribute("expense") Expense newExpense, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			expenseServ.createOne(newExpense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/expense/{id}/edit")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("expenseEditForm") Expense expense, Model model) {
		model.addAttribute("expense", expenseServ.getOne(id));
		return "editExpense.jsp";
	}
	
	@PutMapping("/expense/{id}/update")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expenseEditForm") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "editExpense.jsp";
		} else {
			expenseServ.updateOne(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/expense/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		expenseServ.deleteOne(id);
		return "redirect:/";
	}
	
	@GetMapping("/expense/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("oneExpense", expenseServ.getOne(id));
		return "viewExpense.jsp";
	}
}
