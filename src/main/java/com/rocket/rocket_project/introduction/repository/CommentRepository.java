package com.rocket.rocket_project.introduction.repository;

import com.rocket.rocket_project.introduction.entity.CommentIntroduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentIntroduction,Long>,CommentRepositoryCustom {

    @Query("SELECT c FROM CommentIntroduction c WHERE c.comment2 IS NULL and c.recruit.recruitSeq= :recruitSeq")
    List<CommentIntroduction> findAllWithNullCommentSeq2(@Param("recruitSeq") Long recruitSeq);

}
