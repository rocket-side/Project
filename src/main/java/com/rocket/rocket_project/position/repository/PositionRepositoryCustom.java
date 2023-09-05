package com.rocket.rocket_project.position.repository;

import com.rocket.rocket_project.position.domain.response.Applicants;
import com.rocket.rocket_project.position.domain.response.PositionCount;
import com.rocket.rocket_project.position.domain.response.RecruitCrew;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface PositionRepositoryCustom {

    List<PositionCount> findRecruitPositions(Long recruitSeq);
    List<Applicants> getRecruitPositionApply(Long recruitSeq);
    List<RecruitCrew> findRecruitCrews(Long recruitSeq);

}
