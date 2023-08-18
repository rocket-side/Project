package com.rocket.rocket_project.skill.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Skill")
@NoArgsConstructor
@Getter
public class Skill {
    @Id
    @Column(name = "skill_seq",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skillSeq;

    @Column(nullable = false)
    private String name;
}
