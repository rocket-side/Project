package com.rocket.rocket_project.recruit.repository;

import com.rocket.rocket_project.recruit.entity.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<ProjectType,Long> {
}
