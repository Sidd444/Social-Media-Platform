package com.example.Social.Media.Platform.Services;

import com.example.Social.Media.Platform.Models.Posts;
import com.example.Social.Media.Platform.Repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    public Posts addPost(Posts post) {
        return postsRepository.save(post);
    }

    public Set<Posts> findPostsByUser(Long userId) {
        return postsRepository.findByUserId(userId);
    }
}


