package com.rocket.rocket_project.introduction.repository;

import com.rocket.rocket_project.introduction.domain.response.IntroductionForCard;
import com.rocket.rocket_project.introduction.entity.Introduction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IntroductionRepositoryCustom {

    Page<Introduction> getIntroductions(Long field_pm, Long type_pm , Pageable pageable);
}
