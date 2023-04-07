package com.codingdojo.com.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.com.dojoandninjas.models.Ninja;
import com.codingdojo.com.dojoandninjas.respositories.NinjaRepo;

@Service
public class NinjaServ {

//	Gets from repo exports to Controller
	
	@Autowired
	private NinjaRepo ninjaRepo;
	
//	Read
	public List<Ninja> getAll(){
		return ninjaRepo.findAll();
	}
	
//	Create
	public Ninja createOne(Ninja i) {
		return ninjaRepo.save(i);
	}
	
}
