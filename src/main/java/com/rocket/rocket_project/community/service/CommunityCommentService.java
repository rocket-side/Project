package com.rocket.rocket_project.community.service;

import com.rocket.rocket_project.community.dto.request.CommunityCommentRegisterDto;
import com.rocket.rocket_project.community.entity.CommunityComment;
import com.rocket.rocket_project.recruit.domain.request.PageDto;
import org.springframework.data.domain.Page;

public interface CommunityCommentService {

    PageDto<CommunityComment> findAll(int pageNo, String criteria, Long postSeq);

    void registerCommunityComment(Long postSeq, CommunityCommentRegisterDto dto);

    void updateCommunityComment(Long postSeq, CommunityCommentRegisterDto dto, Long commentSeq);

    void deleteComment(Long commentSeq);
}
