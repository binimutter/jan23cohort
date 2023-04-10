package com.example.blackbeltmock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blackbeltmock.models.Sticker;
import com.example.blackbeltmock.repositories.StickerRepo;

@Service
public class StickerServ {
	@Autowired
	private StickerRepo stickRepo;
	
//	======
//	CREATE
//	======
	public Sticker create(Sticker stick) {
		return stickRepo.save(stick);
	}
	
//	public void addCatToStick()
	
//	====
//	READ
//	====
	public List<Sticker> getAll() {
		return stickRepo.findAll();
	}
	public Sticker getOne(Long id) {
		return stickRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Sticker updateOne(Sticker editSticker) {
		return stickRepo.save(editSticker);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		stickRepo.deleteById(id);
	}
}
