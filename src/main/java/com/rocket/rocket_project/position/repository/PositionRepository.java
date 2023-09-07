package com.rocket.rocket_project.position.repository;

import com.rocket.rocket_project.position.entity.RecruitPositionApply;
import com.rocket.rocket_project.recruit.domain.response.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionRepository extends JpaRepository<com.rocket.rocket_project.position.entity.Position,Long>,PositionRepositoryCustom {
    @Query("SELECT new com.rocket.rocket_project.recruit.domain.response.Position(p.positionSeq, p.name) FROM Position p")
    List<Position> findAllPositionSeqAndName();

    @Query("SELECT rpa FROM RecruitPositionApply rpa where rpa.isAccept='수락' and rpa.pk.recruit.recruitSeq = :recruitSeq")
    List<RecruitPositionApply> getPositionByIsAccept(@Param("recruitSeq") Long recruitSeq);

}
