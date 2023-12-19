package com.example.Social.Media.Platform.Repositories;

import com.example.Social.Media.Platform.Models.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

    Set<Friends> findByUserId(Long userId);
}


