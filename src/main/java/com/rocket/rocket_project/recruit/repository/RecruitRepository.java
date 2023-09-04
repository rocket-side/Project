package com.rocket.rocket_project.recruit.repository;

import com.rocket.rocket_project.recruit.domain.request.RecruitLeader;
import com.rocket.rocket_project.recruit.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecruitRepository extends JpaRepository<Recruit,Long> , RecruitRepositoryCustom{

    @Query("SELECT new com.rocket.rocket_project.recruit.domain.request.RecruitLeader(r.leader) FROM Recruit r WHERE r.recruitSeq = :recruitSeq")
    RecruitLeader findRecruitLeaderByRecruitSeq(@Param("recruitSeq") Long recruitSeq);

}
