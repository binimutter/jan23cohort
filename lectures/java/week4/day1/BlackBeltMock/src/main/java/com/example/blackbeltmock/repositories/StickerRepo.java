package com.example.blackbeltmock.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.blackbeltmock.models.Sticker;

@Repository
public interface StickerRepo extends CrudRepository<Sticker, Long> {
	List<Sticker> findAll();
	
//	List<Sticker> findAllByCategory(Category cat);
}
