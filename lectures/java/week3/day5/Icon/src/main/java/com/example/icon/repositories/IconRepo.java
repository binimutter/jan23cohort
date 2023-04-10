package com.example.icon.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.icon.model.Icon;

@Repository
public interface IconRepo extends CrudRepository<Icon, Long> {
	List<Icon> findAll();
}
