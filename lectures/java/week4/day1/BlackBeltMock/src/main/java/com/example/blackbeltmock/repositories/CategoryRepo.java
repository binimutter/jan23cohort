package com.example.blackbeltmock.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.blackbeltmock.models.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	List<Category> findAll();
	
//	List<Category> findAllBySticker(Sticker stick);
}
