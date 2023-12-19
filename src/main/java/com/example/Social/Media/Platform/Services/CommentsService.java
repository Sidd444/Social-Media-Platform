package com.example.Social.Media.Platform.Services;

import com.example.Social.Media.Platform.Models.Comments;
import com.example.Social.Media.Platform.Repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public Comments addComment(Comments comment) {
        return commentsRepository.save(comment);
    }

    public Set<Comments> findCommentsByUser(Long userId) {
        return commentsRepository.findByUserId(userId);
    }
}


