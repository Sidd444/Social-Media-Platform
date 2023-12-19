package com.example.Social.Media.Platform.Repositories;

import com.example.Social.Media.Platform.Models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    Set<Posts> findByUserId(Long userId);
}

