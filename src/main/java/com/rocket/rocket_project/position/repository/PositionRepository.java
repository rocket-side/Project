package com.rocket.rocket_project.position.repository;

import com.rocket.rocket_project.recruit.domain.response.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<com.rocket.rocket_project.position.entity.Position,Long> {
    @Query("SELECT new com.rocket.rocket_project.recruit.domain.response.Position(p.positionSeq, p.name) FROM Position p")
    List<Position> findAllPositionSeqAndName();
}
