package com.rocket.rocket_project.recruit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Project_Field")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProjectField {
    @Id
    @Column(name = "field_seq",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fieldSeq;

    @Column(nullable = false)
    private String name;


}
