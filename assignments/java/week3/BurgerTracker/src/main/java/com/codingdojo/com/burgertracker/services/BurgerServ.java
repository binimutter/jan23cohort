package com.codingdojo.com.burgertracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.com.burgertracker.models.Burger;
import com.codingdojo.com.burgertracker.repositories.BurgerRepo;

@Service
public class BurgerServ {
	
	@Autowired
	private BurgerRepo burgerRepo;
	
	// ==========================
    //         METHODS
    // ==========================
	
	//Read
	public List<Burger> allBurgers() {
		return burgerRepo.findAll();
	}
	
	public Burger getOne(Long id) {
		return burgerRepo.findById(id).orElse(null);
	}
	
	//Create
	public Burger create(Burger b) {
		return burgerRepo.save(b);
	}
	
	//Update
	public Burger update(Burger b) {
		return burgerRepo.save(b);
	}
	
	//Delete
	public void deleteOne(Long id) {
		burgerRepo.deleteById(id);
	}
	

}
