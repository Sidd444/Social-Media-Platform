package com.example.Social.Media.Platform.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "friends")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user1_id", nullable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id", nullable = false)
    private User user2;
}

