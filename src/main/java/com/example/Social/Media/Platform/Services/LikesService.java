package com.example.Social.Media.Platform.Services;

import com.example.Social.Media.Platform.Models.Likes;
import com.example.Social.Media.Platform.Repositories.LikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LikesService {

    @Autowired
    private LikesRepository likesRepository;

    public Likes addLike(Likes like) {
        return likesRepository.save(like);
    }

    public Set<Likes> findLikesByUser(Long userId) {
        return likesRepository.findByUserId(userId);
    }
}


