package com.rocket.rocket_project.introduction.service;

import com.rocket.rocket_project.exception.NotFoundException;
import com.rocket.rocket_project.introduction.domain.request.CommentWriter;
import com.rocket.rocket_project.introduction.domain.response.CommentDto;
import com.rocket.rocket_project.introduction.domain.response.IntroductionDto;
import com.rocket.rocket_project.introduction.domain.response.IntroductionForCard;
import com.rocket.rocket_project.introduction.entity.CommentIntroduction;
import com.rocket.rocket_project.introduction.entity.Introduction;
import com.rocket.rocket_project.introduction.repository.CommentRepository;
import com.rocket.rocket_project.introduction.repository.IntroductionRepository;
import com.rocket.rocket_project.position.service.PositionService;
import com.rocket.rocket_project.recruit.domain.response.Field;
import com.rocket.rocket_project.recruit.service.RecruitService;
import com.rocket.rocket_project.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly= true)
public class IntroductionService {

    private final IntroductionRepository introductionRepository;
    private final RecruitService recruitService;
    private final PositionService positionService;
    private final CommentRepository commentRepository;

    public IntroductionDto getIntroduction(Long recruitSeq) {
        Introduction introduction = introductionRepository.findIntroductionByRecruitSeq(recruitSeq);

        return IntroductionDto.builder()
                .recruit(recruitService.getRecruit(recruitSeq))
                .likeCount(introduction.getLikeCount())
                .createdAt(introduction.getCreatedAt())
                .content(introduction.getContent())
                .recruitCrews(positionService.getRecruitCrews(recruitSeq))
                .build();
    }

    public List<CommentDto> getComments(Long recruitSeq) {
        List<CommentIntroduction> topComments = commentRepository.findAllWithNullCommentSeq2(recruitSeq);

        return topComments.stream()
                .map(top->{
                    List<CommentDto> replyList =
                            commentRepository.getReplyList(recruitSeq,top.getCommentSeq());
                    return CommentDto.builder()
                            .commentSeq(top.getCommentSeq())
                            .memberSeq(top.getMemberSeq())
                            .recruitSeq(recruitSeq)
                            .createAt(top.getCreateAt())
                            .content(top.getContent())
                            .ReplyList(replyList)
                            .build();
                })
                .collect(Collectors.toList());
    }

    public Boolean isRedirectUser(Long commentSeq, Long memberSeq){
        CommentWriter commentWriter = commentRepository.findCommentIntroductionByCommentSeq(commentSeq);
        if(commentWriter.getMemberSeq() == memberSeq) return true;
        else return false;
    }

    public Boolean isIntroductionWriter(Long recruitSeq,Long accessUserSeq){
        Introduction introduction = introductionRepository.findById(recruitSeq)
                .orElseThrow(() -> new NotFoundException("해당 소개글은 존재하지 않습니다."));
        if(accessUserSeq == introduction.getRecruit().getLeader()) return true;
        else return false;
    }

    public Page<IntroductionForCard> getIntroductionCards(Long fieldSeq, Long typeSeq, Pageable pageable, Long memberSeq) {
        Page<Introduction> introductions = introductionRepository.getIntroductions(fieldSeq,typeSeq, PageUtil.convertToZeroBasePageWithSort(pageable));

         List<IntroductionForCard> cards = introductions.stream()
                .map(introduce-> {
                    Field field = new Field(introduce.getRecruit().getProjectField().getFieldSeq(),
                            introduce.getRecruit().getProjectField().getName());
                    return IntroductionForCard.builder()
                            .recruitSeq(introduce.getRecruitSeq())
                            .name(introduce.getRecruit().getName())
                            .status(introduce.getStatus())
                            .info(introduce.getRecruit().getInfo())
                            .field(field)
                            .build();
                })
                .collect(Collectors.toList());
        return new PageImpl<>(cards,introductions.getPageable(),introductions.getTotalElements());
    }
}
