package com.rocket.rocket_project.recruit.repository;

import com.rocket.rocket_project.recruit.entity.ProjectField;
import com.rocket.rocket_project.recruit.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<ProjectField,Long> {

    ProjectField save(ProjectField projectField);
}
