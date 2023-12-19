package com.example.Social.Media.Platform.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "followers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @ManyToOne
    @JoinColumn(name = "following_id", nullable = false)
    private User following;
}

