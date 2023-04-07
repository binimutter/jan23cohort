package com.example.fullstacklecture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fullstacklecture.models.Puppy;
import com.example.fullstacklecture.repositories.PuppyRepo;

@Service
public class PuppyServ {

	@Autowired
	private PuppyRepo pupRepo;
	
	
//	======
//	CREATE
//	======
	public Puppy savePup(Puppy pup) {
		return pupRepo.save(pup);
	}
	
//	====
//	READ
//	====
	public List<Puppy> getAll() {
		return pupRepo.findAll();
	}
	public Puppy getOne(Long id) {
		return pupRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Puppy updateOne(Puppy editPuppy) {
		return pupRepo.save(editPuppy);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		pupRepo.deleteById(id);
	}
}
