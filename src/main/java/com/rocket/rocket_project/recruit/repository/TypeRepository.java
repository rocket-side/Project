package com.rocket.rocket_project.recruit.repository;

import com.rocket.rocket_project.recruit.domain.response.Type;
import com.rocket.rocket_project.recruit.entity.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<ProjectType,Long> {
    @Query("SELECT new com.rocket.rocket_project.recruit.domain.response.Type(t.typeSeq,t.name) From ProjectType t")
    List<Type> findAllBy();
}
