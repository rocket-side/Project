package com.rocket.rocket_project.position.repository;

import com.querydsl.core.types.Projections;
import com.rocket.rocket_project.position.domain.response.PositionCount;
import com.rocket.rocket_project.position.entity.Position;
import com.rocket.rocket_project.position.entity.QPosition;
import com.rocket.rocket_project.position.entity.QRecruitPositionCount;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class PositionRepositoryImpl  extends QuerydslRepositorySupport implements PositionRepositoryCustom {

    public PositionRepositoryImpl(){super(Position.class);}

    QRecruitPositionCount recruitPositionCount = QRecruitPositionCount.recruitPositionCount;
    QPosition position = QPosition.position;

    /**
     * 공고 모집현황 중 모집 포지션 번호/이름/모집수
     * @param recruitSeq
     * @return
     */
    @Override
    public List<PositionCount> findRecruitPositions(Long recruitSeq){
       return from(recruitPositionCount)
                .leftJoin(recruitPositionCount.pk.position,position)
                .on(position.positionSeq.eq(recruitPositionCount.pk.position.positionSeq))
                .select(Projections.constructor(PositionCount.class, position.positionSeq,
                        recruitPositionCount.pk.recruit.recruitSeq,
                        recruitPositionCount.count,position.name))
                .where(recruitPositionCount.pk.recruit.recruitSeq.eq(recruitSeq))
                .fetch();
    }

}
