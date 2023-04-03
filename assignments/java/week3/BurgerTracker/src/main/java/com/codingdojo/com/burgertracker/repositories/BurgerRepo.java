package com.codingdojo.com.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.com.burgertracker.models.Burger;

@Repository
public interface BurgerRepo extends CrudRepository<Burger, Long> {
	
	List<Burger> findAll();
}
