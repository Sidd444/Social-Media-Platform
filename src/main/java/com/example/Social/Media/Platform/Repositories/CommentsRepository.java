package com.example.Social.Media.Platform.Repositories;

import com.example.Social.Media.Platform.Models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

    Set<Comments> findByUserId(Long userId);
}


