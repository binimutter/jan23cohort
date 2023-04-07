package com.codingdojo.com.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.com.dojoandninjas.models.Dojo;
import com.codingdojo.com.dojoandninjas.respositories.DojoRepo;

@Service
public class DojoServ {

//	Gets from repo exports to Controller
	
	@Autowired
	private DojoRepo dojoRepo;
	
//	Read
	public List<Dojo> getAll(){
		return dojoRepo.findAll();
	}
	
	public Dojo getOne(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
//	Create
	public Dojo createOne(Dojo i) {
		return dojoRepo.save(i);
	}
	
}
