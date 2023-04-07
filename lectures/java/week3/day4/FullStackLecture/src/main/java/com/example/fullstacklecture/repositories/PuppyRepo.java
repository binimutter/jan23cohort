package com.example.fullstacklecture.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.fullstacklecture.models.Puppy;

@Repository
public interface PuppyRepo extends CrudRepository<Puppy, Long> {

	List<Puppy> findAll();
}
