package com.rocket.rocket_project.recruit.repository;

import com.rocket.rocket_project.recruit.domain.response.Keep;
import com.rocket.rocket_project.recruit.domain.response.PositionForCards;
import com.rocket.rocket_project.recruit.domain.response.RecruitTag;
import com.rocket.rocket_project.recruit.entity.Recruit;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.domain.Pageable;


import java.util.List;

@NoRepositoryBean
public interface RecruitRepositoryCustom {
    Page<Recruit> findAllBy(Long field_pm, Long type_pm, Pageable pageable);
    List<PositionForCards> findAllRecruitPosition();
    List<Keep> findAllKeepList(Long recruitSeq);

}

