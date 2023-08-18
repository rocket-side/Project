package com.rocket.rocket_project.recruit.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Type")
@NoArgsConstructor
@Getter
public class Type {
    @Id
    @Column(name = "type_seq",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeSeq;

    @Column(nullable = false)
    private  String name;
}
