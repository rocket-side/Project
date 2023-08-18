package com.rocket.rocket_project.recruit.entity;

import com.rocket.rocket_project.feild.entity.Field;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Recruit")
@NoArgsConstructor
@Getter
public class Recruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_seq", nullable = false)
    private Integer recruitSeq;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private Integer leader;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "create_at",nullable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String info;

    @JoinColumn(name = "field_seq",nullable = false)
    @ManyToOne
    private Field fieldCode;

}
