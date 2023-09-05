package com.rocket.rocket_project.position.service;

import com.rocket.rocket_project.position.domain.response.Applicants;
import com.rocket.rocket_project.position.domain.response.ApplyStatus;
import com.rocket.rocket_project.position.domain.response.PositionCount;
import com.rocket.rocket_project.position.domain.response.RecruitCrew;
import com.rocket.rocket_project.position.entity.RecruitPositionApply;
import com.rocket.rocket_project.position.repository.PositionRepository;
import com.rocket.rocket_project.recruit.domain.request.AccessUser;
import com.rocket.rocket_project.recruit.repository.RecruitRepository;
import com.rocket.rocket_project.recruit.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly= true)
public class PositionService {
    private final PositionRepository positionRepository;
    private final RecruitService recruitService;
    public List<ApplyStatus> getApplicantStatue(Long recruitSeq) {
        List<PositionCount> applyInfo = positionRepository.findRecruitPositions(recruitSeq);
        return gatherAll(applyInfo);
    }

    public List<ApplyStatus> gatherAll(List<PositionCount> applyInfo){
        return applyInfo.stream()
                .map(info ->{
                    List<RecruitPositionApply> applyCnt =
                            positionRepository.getPositionByIsAccept(info.getRecruitSeq());
                    return ApplyStatus.builder()
                            .positionSeq(info.getPositionSeq())
                            .recruitSeq(info.getRecruitSeq())
                            .name(info.getName())
                            .wantCnt(info.getCount())
                            .getApplyCnt(applyCnt, info.getPositionSeq())
                            .build();
                })
                .collect(Collectors.toList());
    }

    public List<Applicants> getApplicants(Long recruitSeq) {
        return positionRepository.getRecruitPositionApply(recruitSeq);
    }

    public List<RecruitCrew> getRecruitCrews(Long recruitSeq) {
        List<RecruitCrew> crewList =  positionRepository.findRecruitCrews(recruitSeq);
        crewList.forEach(crew -> {
            Boolean isLeader = recruitService.isGroupLeader(recruitSeq, new AccessUser(crew.getMemberSeq()));
            crew.setCrewRole(isLeader);
        });
        return crewList;
    }

}
