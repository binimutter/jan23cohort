package com.example.friends.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.friends.models.Friend;

@Repository
public interface FriendRepo extends CrudRepository<Friend, Long> {
//	Model gets imported here
	
	List<Friend> findAll();
	
//	No need to add .save here because CrudRepository already has it
	
//	Repo gets "exported" to friendService

}
