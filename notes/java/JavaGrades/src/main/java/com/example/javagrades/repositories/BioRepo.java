package com.example.javagrades.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.javagrades.models.Bio;

@Repository
public interface BioRepo extends CrudRepository<Bio, Long> {

	List<Bio> findAll();
}
