package com.rocket.rocket_project.introduction.entity;

import com.rocket.rocket_project.recruit.entity.Recruit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comment_Introduction")
@NoArgsConstructor
@Getter
public class CommentIntroduction {
    @Id
    @Column(name = "comment_seq",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentSeq;

    @Column(name = "create_at",nullable = false)
    private LocalDateTime createAt;

    @Column(name = "member_seq",nullable = false)
    private Integer memberSeq;

    @Column(nullable = false)
    private String content;

    @JoinColumn(name = "comment_seq2")
    @ManyToOne
    private CommentIntroduction commentSeq2;

    @JoinColumn(name = "recruit_seq",nullable = false)
    @ManyToOne
    private Recruit recruitSeq;

}
