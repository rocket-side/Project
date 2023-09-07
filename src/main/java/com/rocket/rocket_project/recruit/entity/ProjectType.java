package com.rocket.rocket_project.recruit.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Project_Type")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProjectType {
    @Id
    @Column(name = "type_seq",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeSeq;

    @Column(nullable = false)
    private  String name;
}
