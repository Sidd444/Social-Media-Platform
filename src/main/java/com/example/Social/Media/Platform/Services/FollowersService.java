package com.example.Social.Media.Platform.Services;

import com.example.Social.Media.Platform.Models.Followers;
import com.example.Social.Media.Platform.Repositories.FollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FollowersService {

    @Autowired
    private FollowersRepository followersRepository;

    public Followers addFollower(Followers follower) {
        return followersRepository.save(follower);
    }

    public Set<Followers> findFollowersByUser(Long userId) {
        return followersRepository.findByUserId(userId);
    }
}

