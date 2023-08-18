package com.rocket.rocket_project.position.entity;

import com.rocket.rocket_project.recruit.entity.Recruit;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Keep")
@NoArgsConstructor
@Getter
public class Keep {
    @Id
    @MapsId
    @JoinColumn(name = "recruit_seq",nullable = false)
    @ManyToOne
    private Recruit recruitSeq;

    @Column(name = "member_seq",nullable = false)
    private Integer memberSeq;

}
