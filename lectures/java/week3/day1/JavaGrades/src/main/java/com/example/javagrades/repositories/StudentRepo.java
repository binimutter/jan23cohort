package com.example.javagrades.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.javagrades.models.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {
	
//	Gets from Model exports to Service

	List<Student> findAll();
}
