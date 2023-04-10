package com.example.icon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.icon.model.Category;
import com.example.icon.repositories.CatRepo;

@Service
public class CatServ {
	@Autowired
	private CatRepo catRepo;
	
//	======
//	CREATE
//	======
	public Category create(Category cat) {
		return catRepo.save(cat);
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
	public Category updateOne(Category editCategory) {
		return catRepo.save(editCategory);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		catRepo.deleteById(id);
	}
}
