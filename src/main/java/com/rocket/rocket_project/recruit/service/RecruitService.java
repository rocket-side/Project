package com.rocket.rocket_project.recruit.service;

import com.rocket.rocket_project.recruit.domain.response.*;
import com.rocket.rocket_project.recruit.entity.Recruit;
import com.rocket.rocket_project.recruit.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly= true)
public class RecruitService {
    private final RecruitRepository recruitRepository;
    /**
     * 모든 공고 카드 목록 조회
     * @return 프로젝트 리스트
     */
    public Page<RecruitCard> getRecruitCards(Long field, Long type, Pageable pageable,Long accessUser){
        Page<Recruit> infoForCards = recruitRepository.findAllBy(field,type,pageable);
        return putTogether(infoForCards,accessUser);
    }

    public  Page<RecruitCard> putTogether(Page<Recruit> infoForCards, Long accessUser){
        List<RecruitCard> recruitCards = infoForCards.stream()
                .map(info -> {
                    Type type = new Type(info.getProjectType().getTypeSeq(), info.getProjectType().getName());
                    Field field = new Field(info.getProjectField().getFieldSeq(), info.getProjectField().getName());

                    // Keep 리스트에서  해당 recruit 번호를 갖고 있는 멤버들을 ArrayList에 담기
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

        return new PageImpl<>(recruitCards);
    }

    public List<RecruitTag> getRecruitTagList() {
    }
}
