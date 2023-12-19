package com.example.Social.Media.Platform.Repositories;

import com.example.Social.Media.Platform.Models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

}

