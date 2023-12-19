package com.example.Social.Media.Platform.Models;

import lombok.*;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comments> comments = new HashSet<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Likes> likes = new HashSet<>();

}
