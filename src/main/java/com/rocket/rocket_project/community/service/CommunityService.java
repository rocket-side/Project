package com.rocket.rocket_project.community.service;

import com.rocket.rocket_project.community.dto.request.CommunityRegisterDto;
import com.rocket.rocket_project.community.dto.response.CommunityResponseDto;
import com.rocket.rocket_project.community.entity.Community;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommunityService {

    void registerCommunity(CommunityRegisterDto dto);

    CommunityResponseDto getCommunity(Long postSeq);

    void updateCommunity(Long postSeq, CommunityRegisterDto dto);

    void deleteCommunity(Long postSeq);

    Page<Community> getPageCommunity(int pageNo, String criteria);
}
