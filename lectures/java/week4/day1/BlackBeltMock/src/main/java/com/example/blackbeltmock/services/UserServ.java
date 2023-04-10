package com.example.blackbeltmock.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.blackbeltmock.models.LoginUser;
import com.example.blackbeltmock.models.User;
import com.example.blackbeltmock.repositories.UserRepo;

@Service
public class UserServ {

	@Autowired
	private UserRepo userRepo;
	
    // ==========================
    //        REGISTRATION
    // ==========================
	
	public User register(User newUser, BindingResult result) {
        if(userRepo.findByUsername(newUser.getUsername()).isPresent()) {
            result.rejectValue("username", "Unique", "This username is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
	
    // ==========================
    //        LOGIN
    // ==========================
	
	
	public User login(LoginUser newLogin, BindingResult result) {
        Optional<User> potentialUser = userRepo.findByUsername(newLogin.getUsername());
        if(!potentialUser.isPresent()) {
            result.rejectValue("username", "Unique", "Unknown username!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
	
	// Get All
	public List<User> getAllUsers() {
		return userRepo.findAll();

	}
	
	// Get One
	public User getUser(Long id) {
		User user = userRepo.findById(id).orElse(null);
		return user;
	}
	
	// Update
	public User updateOne(User user) {
		return userRepo.save(user);
	}
	
	// Delete
	public void deleteOne(Long id) {
		userRepo.deleteById(id);
	}
}
