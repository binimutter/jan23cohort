package com.vdh.ContactProject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vdh.ContactProject.models.Contact;
import com.vdh.ContactProject.repositories.ContactRepository;

@Service
public class ContactService {
	
//	========
//	FIELD
//	========
//	adding the repo dependency
	private final ContactRepository contactRepo;
	
//	========
//	CONSTRUCTOR
//	========
//	enables us to use CrudRepository library of pre-written code
	
	public ContactService(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}
	
//	========
//	METHODS
//	========
	
	
//	CREATE
	
	
//	FIND ALL
	public List<Contact> allContacts() {
		return contactRepo.findAll();
	}

}
