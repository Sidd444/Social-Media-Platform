package com.example.Social.Media.Platform.Controllers;

import com.example.Social.Media.Platform.Models.Followers;
import com.example.Social.Media.Platform.Models.User;
import com.example.Social.Media.Platform.Services.FollowersService;
import com.example.Social.Media.Platform.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/followers")
public class FollowersController {

    @Autowired
    private FollowersService followersService;

    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<Followers> addFollower(@RequestBody Followers follower) {
        Followers savedFollower = followersService.addFollower(follower);
        return new ResponseEntity<>(savedFollower, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Set<Followers>> getFollowersByUserId(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            Set<Followers> followers = followersService.findFollowersByUser(userId);
            return new ResponseEntity<>(followers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

