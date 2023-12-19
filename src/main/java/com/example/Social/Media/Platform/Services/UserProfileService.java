package com.example.Social.Media.Platform.Services;

import com.example.Social.Media.Platform.Models.UserProfile;
import com.example.Social.Media.Platform.Repositories.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile addUserProfile(UserProfile userProfile) {
        // Add validation or other business logic as needed
        return userProfileRepository.save(userProfile);
    }
}

