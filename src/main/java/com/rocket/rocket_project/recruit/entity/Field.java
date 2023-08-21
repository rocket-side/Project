package com.rocket.rocket_project.recruit.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Field")
@NoArgsConstructor
@Getter
public class Field {
    @Id
    @Column(name = "field_seq",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldSeq;

    @Column(nullable = false)
    private String name;


}
