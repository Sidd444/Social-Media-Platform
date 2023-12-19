package com.example.Social.Media.Platform.Controllers;

import com.example.Social.Media.Platform.Models.UserProfile;
import com.example.Social.Media.Platform.Services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-profiles")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PostMapping("/add")
    public ResponseEntity<UserProfile> addUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile savedUserProfile = userProfileService.addUserProfile(userProfile);
        return new ResponseEntity<>(savedUserProfile, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfileById(@PathVariable Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}

