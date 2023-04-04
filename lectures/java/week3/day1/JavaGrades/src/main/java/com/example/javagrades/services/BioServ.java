package com.example.javagrades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javagrades.models.Bio;
import com.example.javagrades.repositories.BioRepo;


@Service
public class BioServ {

	@Autowired
	private BioRepo bioRepo;
	
//	Read
	public List<Bio> getAll(){
		return bioRepo.findAll();
	}
	
	public Bio getOne(Long id) {
		return bioRepo.findById(id).orElse(null);
	}
	
//	Create
	public Bio createOne(Bio i) {
		return bioRepo.save(i);
	}
	
//	Update
	public Bio updateOne(Bio i) {
		return bioRepo.save(i);
	}
	
//	Delete
	public void deleteOne(Long id) {
		bioRepo.deleteById(id);
	}
}
