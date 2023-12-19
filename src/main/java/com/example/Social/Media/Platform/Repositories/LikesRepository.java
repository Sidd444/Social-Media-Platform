package com.example.Social.Media.Platform.Repositories;

import com.example.Social.Media.Platform.Models.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {

    Set<Likes> findByUserId(Long userId);
}


