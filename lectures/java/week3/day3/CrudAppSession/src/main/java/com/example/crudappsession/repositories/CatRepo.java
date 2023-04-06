package com.example.crudappsession.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.crudappsession.models.Category;

@Repository
public interface CatRepo extends CrudRepository<Category, Long> {

	List<Category> findAll();
}
