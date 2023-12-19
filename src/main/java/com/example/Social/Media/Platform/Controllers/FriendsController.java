package com.example.Social.Media.Platform.Controllers;

import com.example.Social.Media.Platform.Models.Friends;
import com.example.Social.Media.Platform.Models.User;
import com.example.Social.Media.Platform.Services.FriendshipService;
import com.example.Social.Media.Platform.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/friends")
public class FriendsController {

    @Autowired
    private FriendshipService friendshipService;

    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<Friends> addFriendship(@RequestBody Friends friendship) {
        Friends savedFriendship = friendshipService.addFriendship(friendship);
        return new ResponseEntity<>(savedFriendship, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Set<Friends>> getFriendshipsByUserId(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            Set<Friends> friendships = friendshipService.findFriendshipsByUser(userId);
            return new ResponseEntity<>(friendships, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



