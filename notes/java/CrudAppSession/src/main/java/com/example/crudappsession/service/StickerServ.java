package com.example.crudappsession.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudappsession.models.Sticker;
import com.example.crudappsession.repositories.StickerRepo;

@Service
public class StickerServ {

	@Autowired
	private StickerRepo stickerRepo;
	
//	======
//	CREATE
//	======
	public Sticker createOne(Sticker c) {
		return stickerRepo.save(c);
	}
	
//	====
//	READ
//	====
	public List<Sticker> getAll() {
		return stickerRepo.findAll();
	}
	public Sticker getOne(Long id) {
		return stickerRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Sticker updateOne(Sticker editSticker) {
		return stickerRepo.save(editSticker);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		stickerRepo.deleteById(id);
	}
}
