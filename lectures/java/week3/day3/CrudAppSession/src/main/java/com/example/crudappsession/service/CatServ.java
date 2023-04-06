package com.example.crudappsession.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudappsession.models.Category;
import com.example.crudappsession.repositories.CatRepo;

@Service
public class CatServ {

	@Autowired
	private CatRepo catRepo;
//	======
//	CREATE
//	======
	public Category createOne(Category c) {
		return catRepo.save(c);
	}
	
//	====
//	READ
//	====
	public List<Category> getAll() {
		return catRepo.findAll();
	}
	public Category getOne(Long id) {
		return catRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Category updateOne(Category c) {
		return catRepo.save(c);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		catRepo.deleteById(id);
	}
}
