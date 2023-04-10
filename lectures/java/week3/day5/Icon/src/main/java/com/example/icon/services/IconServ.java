package com.example.icon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.icon.model.Icon;
import com.example.icon.repositories.IconRepo;

@Service
public class IconServ {

	@Autowired
	private IconRepo iconRepo;
	
//	======
//	CREATE
//	======
	public Icon create(Icon icon) {
		return iconRepo.save(icon);
	}
	
//	====
//	READ
//	====
	public List<Icon> getAll() {
		return iconRepo.findAll();
	}
	public Icon getOne(Long id) {
		return iconRepo.findById(id).orElse(null);
	}
	
//	======
//	UPDATE
//	======
	public Icon updateOne(Icon editIcon) {
		return iconRepo.save(editIcon);
	}
	
//	======
//	DELETE
//	======
	public void deleteOne(Long id) {
		iconRepo.deleteById(id);
	}
}
