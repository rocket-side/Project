package com.rocket.rocket_project.recruit.repository;

import com.rocket.rocket_project.recruit.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitRepository extends JpaRepository<Recruit,Long> , RecruitRepositoryCustom{

}
