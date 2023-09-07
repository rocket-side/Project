package com.rocket.rocket_project.community.service.impl;

import com.rocket.rocket_project.community.dto.request.CommunityCommentRegisterDto;
import com.rocket.rocket_project.community.entity.Community;
import com.rocket.rocket_project.community.entity.CommunityComment;
import com.rocket.rocket_project.community.repository.CommunityCommentRepository;
import com.rocket.rocket_project.community.repository.CommunityRepository;
import com.rocket.rocket_project.community.service.CommunityCommentService;
import com.rocket.rocket_project.community.service.CommunityService;
import com.rocket.rocket_project.recruit.domain.request.PageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityCommentServiceImpl implements CommunityCommentService {

    private final CommunityCommentRepository communityCommentRepository;

    private final CommunityRepository communityRepository;

    @Override
    public PageDto<CommunityComment> findAll(int pageNo, String criteria, Long postSeq) {
        Pageable pageable = PageRequest.of(pageNo, 5, Sort.by(Sort.Direction.DESC, criteria));
        Page<CommunityComment> communityComments =  communityCommentRepository.findAllByPostSeq(postSeq, pageable);
        return PageDto.of(communityComments,communityComments.getContent());

    }

    @Override
    public void registerCommunityComment(Long postSeq, CommunityCommentRegisterDto dto) {
        Community community = communityRepository.findById(postSeq).orElseThrow();
        CommunityComment communityComment2 = communityCommentRepository.findById(dto.getCommentSeq()).orElse(null);
        CommunityComment communityComment = CommunityComment.builder()
                .memberSeq(dto.getMemberSeq())
                .createAt(dto.getCreateAt())
                .content(dto.getContent())
                .postSeq(community)
                .commentSeq2(communityComment2)
                .build();

        communityCommentRepository.save(communityComment);
    }

    @Override
    public void updateCommunityComment(Long postSeq, CommunityCommentRegisterDto dto, Long commentSeq) {
        Community community = communityRepository.findById(postSeq).orElseThrow();
        CommunityComment communityComment = communityCommentRepository.findById(commentSeq).orElseThrow();

        CommunityComment updateComment = CommunityComment.builder()
                .CommentSeq(commentSeq)
                .commentSeq2(communityComment.getCommentSeq2())
                .postSeq(community)
                .content(dto.getContent())
                .createAt(communityComment.getCreateAt())
                .memberSeq(communityComment.getMemberSeq())
                .build();

        communityCommentRepository.save(updateComment);
    }

    @Override
    public void deleteComment(Long commentSeq) {
        communityCommentRepository.deleteById(commentSeq);
    }
}
