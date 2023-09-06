package com.rocket.rocket_project.community.repository;

import com.rocket.rocket_project.community.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
