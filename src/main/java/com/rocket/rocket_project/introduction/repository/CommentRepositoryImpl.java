package com.rocket.rocket_project.introduction.repository;

import com.querydsl.core.types.Projections;
import com.rocket.rocket_project.introduction.domain.response.CommentDto;
import com.rocket.rocket_project.introduction.entity.CommentIntroduction;
import com.rocket.rocket_project.introduction.entity.QCommentIntroduction;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class CommentRepositoryImpl extends QuerydslRepositorySupport implements CommentRepositoryCustom {
    public CommentRepositoryImpl() {super(CommentIntroduction.class);}

    QCommentIntroduction comment1 = QCommentIntroduction.commentIntroduction;
    QCommentIntroduction comment2 = QCommentIntroduction.commentIntroduction;
    @Override
    public List<CommentDto>getReplyList(Long recruitSeq,Long commentSeq){
        return from(comment1)
                .leftJoin(comment2)
                .on(comment1.commentSeq.eq(comment2.comment2.commentSeq))
                .where(comment1.recruit.recruitSeq.eq(recruitSeq)
                        .and(comment1.comment2.commentSeq.eq(commentSeq)))
                .select(Projections.constructor(CommentDto.class,
                        comment1.commentSeq,comment1.memberSeq,
                        comment1.recruit.recruitSeq,
                        comment1.createAt,comment1.content))
                .fetch();
    }
}