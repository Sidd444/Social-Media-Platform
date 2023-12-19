package com.example.Social.Media.Platform.Models;

import lombok.*;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    private Set<Friends> friends = new HashSet<>();

    @OneToMany(mappedBy = "follower", cascade = CascadeType.ALL)
    private Set<Followers> followers = new HashSet<>();

    @OneToMany(mappedBy = "following", cascade = CascadeType.ALL)
    private Set<Followers> following = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Likes> likes = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Posts> posts = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comments> comments = new HashSet<>();

}
