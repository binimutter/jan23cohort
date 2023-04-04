package com.example.javagrades.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javagrades.models.Student;
import com.example.javagrades.repositories.StudentRepo;


@Service
public class StudentServ {

//	Gets from repo exports to Controller
	
	@Autowired
	private StudentRepo studentRepo;
	
//	Read
	public List<Student> getAll(){
		return studentRepo.findAll();
	}
	
	public Student getOne(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
//	Create
	public Student createOne(Student i) {
		return studentRepo.save(i);
	}
	
//	Update
	public Student updateOne(Student i) {
		return studentRepo.save(i);
	}
	
//	Delete
	public void deleteOne(Long id) {
		studentRepo.deleteById(id);
	}
}