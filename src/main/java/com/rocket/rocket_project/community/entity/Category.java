package com.rocket.rocket_project.community.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Category")
@NoArgsConstructor
@Getter
public class Category {
    @Id
    @Column(name = "category_seq",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categorySeq;

    @Column(nullable = false)
    private String name;
}
