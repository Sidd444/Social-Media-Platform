package com.example.Social.Media.Platform.Repositories;

import com.example.Social.Media.Platform.Models.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FollowersRepository extends JpaRepository<Followers, Long> {

    Set<Followers> findByUserId(Long userId);
}


