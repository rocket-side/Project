package com.rocket.rocket_project.position.repository;

import com.rocket.rocket_project.position.entity.Keep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeepRepository extends JpaRepository<Keep, Keep.Pk> {

}
