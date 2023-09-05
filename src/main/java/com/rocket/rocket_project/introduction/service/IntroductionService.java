package com.rocket.rocket_project.introduction.service;

import com.rocket.rocket_project.introduction.domain.response.IntroductionDto;
import com.rocket.rocket_project.introduction.entity.Introduction;
import com.rocket.rocket_project.introduction.repository.IntroductionRepository;
import com.rocket.rocket_project.position.service.PositionService;
import com.rocket.rocket_project.recruit.domain.response.RecruitDto;
import com.rocket.rocket_project.recruit.repository.RecruitRepository;
import com.rocket.rocket_project.recruit.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly= true)
public class IntroductionService {

    private final IntroductionRepository introductionRepository;
    private final RecruitService recruitService;
    private final PositionService positionService;

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
}
