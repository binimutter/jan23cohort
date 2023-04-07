package com.codingdojo.com.safetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.com.safetravels.models.Expense;
import com.codingdojo.com.safetravels.repositories.ExpenseRepo;

@Service
public class ExpenseServ {

	@Autowired
	private ExpenseRepo expenseRepo;
	
//	Read
	public List<Expense> getAll(){
		return expenseRepo.findAll();
	}
	
	public Expense getOne(Long id) {
		return expenseRepo.findById(id).orElse(null);
	}
	
//	Create
	public Expense createOne(Expense i) {
		return expenseRepo.save(i);
	}
	
//	Update
	public Expense updateOne(Expense i) {
		return expenseRepo.save(i);
	}
	
//	Delete
	public void deleteOne(Long id) {
		expenseRepo.deleteById(id);
	}
}
