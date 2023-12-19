package com.example.Social.Media.Platform.Controllers;

import com.example.Social.Media.Platform.Models.Posts;
import com.example.Social.Media.Platform.Models.User;
import com.example.Social.Media.Platform.Services.PostsService;
import com.example.Social.Media.Platform.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<Posts> addPost(@RequestBody Posts post) {
        Posts savedPost = postsService.addPost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Set<Posts>> getPostsByUserId(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            Set<Posts> posts = postsService.findPostsByUser(userId);
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

