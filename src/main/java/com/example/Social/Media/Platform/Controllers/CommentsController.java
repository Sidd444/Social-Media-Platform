package com.example.Social.Media.Platform.Controllers;

import com.example.Social.Media.Platform.Models.Comments;
import com.example.Social.Media.Platform.Models.User;
import com.example.Social.Media.Platform.Services.CommentsService;
import com.example.Social.Media.Platform.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity<Comments> addComment(@RequestBody Comments comment) {
        Comments savedComment = commentsService.addComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Set<Comments>> getCommentsByUserId(@PathVariable Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            Set<Comments> comments = commentsService.findCommentsByUser(userId);
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

