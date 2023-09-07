package com.rocket.rocket_project.recruit.repository;

import com.rocket.rocket_project.recruit.domain.response.Field;
import com.rocket.rocket_project.recruit.entity.ProjectField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<ProjectField, Long> {
    ProjectField save(ProjectField projectField);

    @Query("SELECT new com.rocket.rocket_project.recruit.domain.response.Field(f.fieldSeq, f.name) FROM ProjectField f")
    List<Field> findAllBy();
}
