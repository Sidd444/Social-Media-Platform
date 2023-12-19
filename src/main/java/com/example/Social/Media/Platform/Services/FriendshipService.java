package com.example.Social.Media.Platform.Services;

import com.example.Social.Media.Platform.Models.Friends;
import com.example.Social.Media.Platform.Models.User;
import com.example.Social.Media.Platform.Repositories.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FriendshipService {

    @Autowired
    private FriendsRepository friendsRepository;

    public Friends addFriendship(Friends friendship) {
        return friendsRepository.save(friendship);
    }

    public Set<Friends> findFriendshipsByUser(Long userId) {
        return friendsRepository.findByUserId(userId);
    }
}



