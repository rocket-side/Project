package com.rocket.rocket_project.recruit.entity;

import lombok.Builder;
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

    @JoinColumn(name = "field_seq")
    @ManyToOne
    private Field fieldCode;

    @JoinColumn(name = "type_seq",nullable = false)
    @ManyToOne
    private Type typeCode;

    @Builder
    public Recruit(String name, String state, Integer leader, LocalDate startDate, LocalDate endDate,
                   LocalDateTime createAt, String content, String info, Field fieldCode, Type typeCode) {
        this.name = name;
        this.state = state;
        this.leader = leader;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createAt = createAt;
        this.content = content;
        this.info = info;
        this.fieldCode = fieldCode;
        this.typeCode = typeCode;
    }
}
