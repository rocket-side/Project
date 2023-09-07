package com.rocket.rocket_project.recruit.entity;

import com.rocket.rocket_project.position.entity.Keep;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Recruit")
@NoArgsConstructor
@Getter
public class Recruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruit_seq", nullable = false)
    private Long recruitSeq;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Long leader;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String info;

    @JoinColumn(name = "field_seq")
    @ManyToOne
    private ProjectField projectField;

    @JoinColumn(name = "type_seq",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectType projectType;

    @OneToMany(mappedBy = "recruitSeq",fetch = FetchType.EAGER)
    private List<Keep> keepList = new ArrayList<>();

    public void addKeep(Keep keep){
        this.keepList.add(keep);
    }
    public void removeKeep(Keep keep){
        this.keepList.remove(keep);
    }
    public Recruit(Long recruitSeq, String name, ProjectType type, ProjectField field,List<Keep> keepList) {
        this.recruitSeq = recruitSeq;
        this.name = name;
        this.projectField = field;
        this.projectType = type;
        this.keepList = keepList;


    }

    @Builder
    public Recruit(String name, String status, Long leader, LocalDate startDate, LocalDate endDate,
                   LocalDateTime createdAt, String content, String info, ProjectField field, ProjectType type, List<Keep> keepList) {
        this.name = name;
        this.status = status;
        this.leader = leader;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.content = content;
        this.info = info;
        this.projectField = field;
        this.projectType = type;
        this.keepList= keepList;
    }
}
