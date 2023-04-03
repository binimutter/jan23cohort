package com.vdh.ContactProject.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vdh.ContactProject.models.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long>{
	List<Contact> findAll();
	
//	Repo gets imported into service

}
