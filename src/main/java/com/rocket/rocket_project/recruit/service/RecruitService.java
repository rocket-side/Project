package com.rocket.rocket_project.recruit.service;

import com.rocket.rocket_project.position.repository.PositionRepository;
import com.rocket.rocket_project.recruit.domain.request.AccessUser;
import com.rocket.rocket_project.recruit.domain.request.RecruitLeader;
import com.rocket.rocket_project.recruit.domain.response.*;
import com.rocket.rocket_project.recruit.entity.ProjectField;
import com.rocket.rocket_project.recruit.entity.Recruit;
import com.rocket.rocket_project.recruit.repository.FieldRepository;
import com.rocket.rocket_project.recruit.repository.RecruitRepository;
import com.rocket.rocket_project.recruit.repository.SkillRepository;
import com.rocket.rocket_project.recruit.repository.TypeRepository;
import com.rocket.rocket_project.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly= true)
public class RecruitService {
    private final RecruitRepository recruitRepository;
    private final FieldRepository fieldRepository;
    private final TypeRepository typeRepository;
    private final PositionRepository positionRepository;
    private final SkillRepository skillRepository;

    /**
     * 모든 공고 카드 목록 조회
     * @return 프로젝트 리스트
     */
    public Page<RecruitCard> getRecruitCards(Long field, Long type, Pageable pageable,Long accessUser){
        Page<Recruit> infoForCards = recruitRepository.findAllBy(field,type, PageUtil.convertToZeroBasePageWithSort(pageable));
        return putTogether(infoForCards,accessUser);
    }

    public  Page<RecruitCard> putTogether(Page<Recruit> infoForCards, Long accessUser){
        List<RecruitCard> recruitCards = infoForCards.getContent().stream()
                .map(info -> {
                    Type type = new Type(info.getProjectType().getTypeSeq(), info.getProjectType().getName());
                    Field field = new Field(info.getProjectField().getFieldSeq(), info.getProjectField().getName());

                    // Keep 리스트에서  해당 recruit 번호를 갖고 있는 멤버들을 ArrayList 에 담기
                    List<Keep> keepList = recruitRepository.findAllKeepList(info.getRecruitSeq());
                    List<PositionForCards> positionList = recruitRepository.findAllRecruitPosition();

                    return RecruitCard.builder()
                            .recruitSeq(info.getRecruitSeq())
                            .name(info.getName())
                            .type(type)
                            .field(field)
                            .isKeepFromKeepList(keepList, info.getRecruitSeq(), accessUser)
                            .recruitPositionList(positionList,info.getRecruitSeq())
                            .build();
                })
                .collect(Collectors.toList());

        return new PageImpl<>(recruitCards,infoForCards.getPageable(), infoForCards.getTotalElements());
    }

    public RecruitTag getRecruitTagList() {
        return RecruitTag.builder()
                .fields(fieldRepository.findAllBy())
                .types(typeRepository.findAllBy())
                .positions(positionRepository.findAllPositionSeqAndName())
                .build();
    }

    public RecruitDto getRecruit(Long recruitSeq) {
        Recruit recruit = recruitRepository.findByRecruitSeq(recruitSeq);
        Type typeDto = new Type(recruit.getProjectType().getTypeSeq(),
                recruit.getProjectType().getName());
        Field fieldDto = new Field(recruit.getProjectField().getFieldSeq(),
                recruit.getProjectField().getName());
        Integer keepCount = recruitRepository.findAllKeepList(recruitSeq).size();
        List<SkillDto> skillDtoList = skillRepository.getRecruitSkills(recruitSeq);

        return RecruitDto.builder()
                .recruitSeq(recruitSeq)
                .name(recruit.getName())
                .status(recruit.getStatus())
                .leader(recruit.getLeader())
                .createdAt(recruit.getCreatedAt())
                .startDate(recruit.getStartDate())
                .endDate(recruit.getEndDate())
                .content(recruit.getContent())
                .info(recruit.getInfo())
                .projectType(typeDto)
                .projectField(fieldDto)
                .keepCount(keepCount)
                .skills(skillDtoList)
                .build();


    }

    public Boolean isGroupLeader(Long recruitSeq, AccessUser accessUser) {
        RecruitLeader recruitLeader = recruitRepository.findRecruitLeaderByRecruitSeq(recruitSeq);
        if(recruitLeader.getLeader() == accessUser.getMemberSeq()) return true;
        else return false;
    }


}
