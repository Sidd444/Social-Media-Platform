package com.example.Social.Media.Platform.Services;

import com.example.Social.Media.Platform.Models.*;

import java.util.*;

import com.example.Social.Media.Platform.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public Set<Followers> getFollowers(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(User::getFollowers).orElse(Collections.emptySet());
    }

    public Set<Likes> getLikes(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(User::getLikes).orElse(Collections.emptySet());
    }

    public Set<Posts> getPosts(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(User::getPosts).orElse(Collections.emptySet());
    }

    public Set<Comments> getComments(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(User::getComments).orElse(Collections.emptySet());
    }

}
