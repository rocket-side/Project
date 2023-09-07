package com.rocket.rocket_project.introduction.repository;

import com.rocket.rocket_project.introduction.domain.response.CommentDto;
import com.rocket.rocket_project.introduction.entity.CommentIntroduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CommentRepositoryCustom  {
    List<CommentDto>getReplyList(Long recruitSeq, Long commentSeq);

}
