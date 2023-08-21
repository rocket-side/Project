package com.rocket.rocket_project.position.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Position")
@NoArgsConstructor
@Getter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_seq",nullable = false)
    private Long positionSeq;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "position_genre_seq",nullable = false)
    private PositionGenre positionGenreSeq;
}
