package com.rocket.rocket_project.recruit.repository;

import com.rocket.rocket_project.recruit.domain.response.SkillDto;
import com.rocket.rocket_project.recruit.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface SkillRepositoryCustom {
    List<SkillDto> getRecruitSkills(Long recruitSeq);
}
