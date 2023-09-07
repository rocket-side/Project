package com.rocket.rocket_project.introduction.entity;

import com.rocket.rocket_project.recruit.entity.Recruit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Introduction")
@NoArgsConstructor
@Getter
public class Introduction {
    @Id
    @Column(name = "recruit_seq")
    private Long recruitSeq;
    @Column(name = "like_count" ,nullable = false)
    private Integer likeCount;
    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;
    @Column
    private String content;

    @Column
    private String status;
    @MapsId
    @JoinColumn(name = "recruit_seq",nullable = false)
    @OneToOne
    private Recruit recruit;

}
