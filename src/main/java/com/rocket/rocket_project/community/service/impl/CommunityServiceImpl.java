package com.rocket.rocket_project.community.service.impl;

import com.rocket.rocket_project.community.dto.request.CommunityRegisterDto;
import com.rocket.rocket_project.community.dto.response.CategoryResponseDto;
import com.rocket.rocket_project.community.dto.response.CommunityResponseDto;
import com.rocket.rocket_project.community.entity.Category;
import com.rocket.rocket_project.community.entity.Community;
import com.rocket.rocket_project.community.repository.CategoryRepository;
import com.rocket.rocket_project.community.repository.CommunityRepository;
import com.rocket.rocket_project.community.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {

    private final CommunityRepository communityRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public Page<Community> getPageCommunity(int pageNo, String criteria) {
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.by(Sort.Direction.DESC, criteria));
        return communityRepository.findAll(pageable);
    }

    @Override
    public void registerCommunity(CommunityRegisterDto dto) {
        Community community = Community.builder()
                .content(dto.getContent())
                .createAt(LocalDateTime.now())
                .memberSeq(dto.getMemberSeq())
                .title(dto.getTitle())
                .likeCount(0)
                .viewCount(0)
                .categorySeq(categoryRepository.findById(dto.getCategorySeq()).get())
                .build();
        communityRepository.save(community);
    }

    @Override
    public CommunityResponseDto getCommunity(Long postSeq) {
        Community community = communityRepository.findById(postSeq).orElseThrow();
        Category category = categoryRepository.findById(community.getCategorySeq().getCategorySeq()).get();

        return CommunityResponseDto.builder()
                .title(community.getTitle())
                .content(community.getContent())
                .postSeq(community.getPostSeq())
                .memberSeq(community.getMemberSeq())
                .likeCount(community.getLikeCount())
                .viewCount(community.getViewCount() + 1)
                .createAt(community.getCreateAt())
                .categoryResponseDto(new CategoryResponseDto(category.getCategorySeq(), category.getName()))
                .build();
    }

    @Override
    public void updateCommunity(Long postSeq, CommunityRegisterDto dto) {
        Community community = communityRepository.findById(postSeq).orElseThrow();
        Category category = categoryRepository.findById(community.getCategorySeq().getCategorySeq()).orElseThrow();
        community = Community.builder()
                .memberSeq(dto.getMemberSeq())
                .postSeq(postSeq)
                .content(dto.getContent())
                .createAt(dto.getCreateAt())
                .memberSeq(dto.getMemberSeq())
                .viewCount(community.getViewCount())
                .likeCount(community.getLikeCount())
                .title(dto.getTitle())
                .categorySeq(category)
                .build();

        communityRepository.save(community);
    }

    @Override
    public void deleteCommunity(Long postSeq) {
        communityRepository.deleteById(postSeq);
    }

    @Override
    public void updateLike(Long communitySeq) {
        Community community = communityRepository.findById(communitySeq).orElseThrow();
        community.likeUpdate();
        communityRepository.save(community);
    }
}
