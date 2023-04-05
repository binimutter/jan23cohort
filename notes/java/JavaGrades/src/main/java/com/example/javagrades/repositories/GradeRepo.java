package com.example.javagrades.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.javagrades.models.Grade;

@Repository
public interface GradeRepo extends CrudRepository<Grade, Long> {

	List<Grade> findAll();
}
