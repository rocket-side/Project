package com.rocket.rocket_project.community.repository;

import com.rocket.rocket_project.community.entity.CommunityComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityCommentRepository extends JpaRepository<CommunityComment, Long> {

    Page<CommunityComment> findAllByPostSeq(Long postSeq, Pageable pageable);
}
