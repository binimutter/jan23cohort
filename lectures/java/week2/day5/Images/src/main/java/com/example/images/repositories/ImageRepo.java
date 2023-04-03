package com.example.images.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.images.models.Image;

@Repository
public interface ImageRepo extends CrudRepository<Image, Long> {
	
	List<Image> findAll();
}
