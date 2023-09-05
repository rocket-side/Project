package com.rocket.rocket_project.introduction.repository;

import com.rocket.rocket_project.introduction.entity.Introduction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntroductionRepository extends JpaRepository<Introduction,Long> {
    Introduction findIntroductionByRecruitSeq(Long recruitSeq);

}
