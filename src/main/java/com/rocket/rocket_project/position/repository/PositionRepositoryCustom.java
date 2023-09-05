package com.rocket.rocket_project.position.repository;

import com.rocket.rocket_project.position.domain.response.PositionCount;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface PositionRepositoryCustom {

    List<PositionCount> findRecruitPositions(Long recruitSeq);

}
