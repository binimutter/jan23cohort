package com.example.javagrades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javagrades.models.Grade;
import com.example.javagrades.repositories.GradeRepo;


@Service
public class GradeServ {

	@Autowired
	private GradeRepo gradeRepo;
	
//	Read
	public List<Grade> getAll(){
		return gradeRepo.findAll();
	}
	
	public Grade getOne(Long id) {
		return gradeRepo.findById(id).orElse(null);
	}
	
//	Create
	public Grade createOne(Grade i) {
		return gradeRepo.save(i);
	}
	
//	Update
	public Grade updateOne(Grade i) {
		return gradeRepo.save(i);
	}
	
//	Delete
	public void deleteOne(Long id) {
		gradeRepo.deleteById(id);
	}

}
