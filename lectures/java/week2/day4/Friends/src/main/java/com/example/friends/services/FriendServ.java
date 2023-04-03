package com.example.friends.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.friends.models.Friend;
import com.example.friends.repositories.FriendRepo;

@Service
public class FriendServ {

	private final FriendRepo friendRepo;
	
	public FriendServ(FriendRepo friendRepo) {
		this.friendRepo = friendRepo;
	}
	
    // ==========================
    //         METHODS
    // ==========================
	
	// lists all friends
	public List<Friend> allFriends() {
		return friendRepo.findAll();
	}
	
    // creates a Friend
    public Friend createFriend(Friend f) {
        return friendRepo.save(f);
    }
}
