package com.rocket.rocket_project.community.entity;

import com.rocket.rocket_project.recruit.entity.Field;
import com.rocket.rocket_project.recruit.entity.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Community")
@NoArgsConstructor
@Getter
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_seq",nullable = false)
    private Integer postSeq;
    @Column(name = "created_at",nullable = false)
    private LocalDateTime createAt;

    @Column(name = "member_seq",nullable = false)
    private Integer memberSeq;

    @Column(name = "view_count",nullable = false)
    private String viewCount;
    @Column(name = "like_count",nullable = false)
    private String likeCount;
    @Column(nullable = false)
    private String content;
    @JoinColumn(name = "category_seq")
    @ManyToOne
    private Category categorySeq;

}
