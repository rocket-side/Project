package com.rocket.rocket_project.position.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Position_Genre")
@NoArgsConstructor
@Getter
public class PositionGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_genre_seq",nullable = false)
    private Long positionGenreSeq;
    @Column
    private String name;
}
