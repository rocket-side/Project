package com.rocket.rocket_project.community.entity;

import com.rocket.rocket_project.introduction.entity.CommentIntroduction;
import com.rocket.rocket_project.recruit.entity.Recruit;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Community_Comment")
@NoArgsConstructor
@Getter
public class CommunityComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_seq",nullable = false)
    private Long CommentSeq;
    @Column(name = "create_at",nullable = false)
    private LocalDateTime createAt;
    @Column(name = "member_seq",nullable = false)
    private Long memberSeq;
    @Column(nullable = false)
    private String content;
    @JoinColumn(name = "comment_seq2")
    @ManyToOne
    private CommentIntroduction commentSeq2;

    @JoinColumn(name = "post_seq",nullable = false)
    @ManyToOne
    private Recruit postSeq;
}
