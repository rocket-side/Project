package com.rocket.rocket_project.recruit.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.rocket.rocket_project.exception.NotFoundException;
import com.rocket.rocket_project.position.entity.QKeep;
import com.rocket.rocket_project.position.entity.QPosition;
import com.rocket.rocket_project.position.entity.QRecruitPositionCount;
import com.rocket.rocket_project.recruit.domain.response.Keep;
import com.rocket.rocket_project.recruit.domain.response.PositionForCards;
import com.rocket.rocket_project.recruit.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RecruitRepositoryImpl extends QuerydslRepositorySupport implements RecruitRepositoryCustom{
    public RecruitRepositoryImpl(){super(Recruit.class);}
    QRecruit recruit = QRecruit.recruit;
    QProjectType type = QProjectType.projectType;
    QProjectField field = QProjectField.projectField;
    QPosition position = QPosition.position;


    /**
     * 파라미터 type과 field만 적용된 전체 공고글 목록 조회
     * @return 공고카드 리스트
     */
    @Override
    public Page<Recruit> findAllBy(Long field_pm, Long type_pm , Pageable pageable) {
        // Create a pageable query
        JPAQuery<Recruit> content = (JPAQuery<Recruit>) from(recruit)
                .innerJoin(recruit.projectType,type)
                .leftJoin(recruit.projectField,field);

        if (field_pm != null) {
            content.where(field.fieldSeq.eq(field_pm));
        }
        if (type_pm != null) {
            content.where(type.typeSeq.eq(type_pm));
        }
        //    private BooleanExpression eqPosition(Long position_pm) {
//        return position_pm != null ? positionGenre.positionGenreSeq.eq(position_pm) : null;
//    }

        List<Recruit> result = content.fetch();
        return new PageImpl<>(result, pageable,content.stream().count());
    }

    /**
     * 해당 공고의 찜한 사람 목록 조회
     * @return Keep 리스트
     */
    @Override
    public List<Keep> findAllKeepList(Long recruitSeq){
        QKeep keep = QKeep.keep;
        return from(recruit)
                .leftJoin(recruit.keepList,keep)
                .on(recruit.recruitSeq.eq(QKeep.keep.recruitSeq.recruitSeq))
                .select(Projections.constructor(Keep.class,keep.recruitSeq.recruitSeq,
                        keep.pk.memberSeq))
                .where(recruit.recruitSeq.eq(recruitSeq))
                .fetch();
    }

    /**
     *  모든 공고들의 포지션 목록 조회
     * @return 공고카드 리스트
     */
    @Override
    public List<PositionForCards> findAllRecruitPosition(){
        QRecruitPositionCount recruitPositionCount = QRecruitPositionCount.recruitPositionCount;
        return from(position)
                .join(recruitPositionCount)
                .on(position.positionSeq.eq(recruitPositionCount.pk.position.positionSeq))
                .select(Projections.constructor(PositionForCards.class,position.positionSeq,
                        position.name,recruitPositionCount.pk.recruit.recruitSeq))
                .fetch();
    }


    @Override
    public Recruit findByRecruitSeq(Long recruitSeq){
       return from(recruit)
                .innerJoin(recruit.projectType,type)
                .leftJoin(recruit.projectField,field)
                .where(recruit.recruitSeq.eq(recruitSeq))
                .fetch().stream().findFirst()
               .orElseThrow(() -> new NotFoundException("공고를 찾을 수 없습니다."));

    }






}
