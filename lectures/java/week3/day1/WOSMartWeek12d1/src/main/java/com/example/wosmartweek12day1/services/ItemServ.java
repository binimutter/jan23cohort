package com.example.wosmartweek12day1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wosmartweek12day1.models.Item;
import com.example.wosmartweek12day1.repositories.ItemRepo;

@Service
public class ItemServ {

	@Autowired
	private ItemRepo itemRepo;
	
    // ==========================
    //         METHODS
    // ==========================
	
//	Read
	public List<Item> allItems() {
		return itemRepo.findAll();
	}
	
	public Item getOne(Long id) {
		return itemRepo.findById(id).orElse(null);
	}
	
//	Create
	public Item createItem(Item i) {
		return itemRepo.save(i);
	}
	
//	Update
	public Item updateItem(Item i) {
		return itemRepo.save(i);
	}
	
//	Delete
	public void deleteOne(Long id) {
		itemRepo.deleteById(id);
	}
}
