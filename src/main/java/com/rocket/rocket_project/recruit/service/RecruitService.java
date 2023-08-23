package com.rocket.rocket_project.recruit.service;

import com.rocket.rocket_project.recruit.domain.response.RecruitCard;
import com.rocket.rocket_project.recruit.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly= true)
public class RecruitService {
    private final RecruitRepository recruitRepository;

    /**
     * 모든 공고 카드 목록 조회
     * @return 프로젝트 리스트
     */
//    public List<RecruitCard> getRecruitCard{
//        return
//    }
}
