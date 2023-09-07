package com.rocket.rocket_project.community.repository;

import com.rocket.rocket_project.community.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
