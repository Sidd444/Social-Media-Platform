package com.example.Social.Media.Platform.Controllers;

import com.example.Social.Media.Platform.Models.Likes;
import com.example.Social.Media.Platform.Models.User;
import com.example.Social.Media.Platform.Services.LikesService;
import com.example.Social.Media.Platform.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikesService likesService;

    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<Likes> addLike(@RequestBody Likes like) {
        Likes savedLike = likesService.addLike(like);
        return new ResponseEntity<>(savedLike, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Set<Likes>> getLikesByUserId(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            Set<Likes> likes = likesService.findLikesByUser(userId);
            return new ResponseEntity<>(likes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

