package com.rocket.rocket_project.position.restController;

import com.rocket.rocket_project.position.domain.response.Applicants;
import com.rocket.rocket_project.position.service.PositionService;
import com.rocket.rocket_project.position.domain.response.ApplyStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/api/recruits")
public class PositionRestController {
    private final PositionService positionService;


    /**
     * 공고 모집현황 정보 -> 모집포지션이름/모집수/지원자수
     * @param recruitSeq
     * @return
     */
    @GetMapping("/{recruit-seq}/applyStatus")
    public ResponseEntity<List<ApplyStatus>> getApplicantStatueList(@PathVariable(name = "recruit-seq") Long recruitSeq){
        return ResponseEntity.ok(positionService.getApplicantStatue(recruitSeq));
    }

    @GetMapping("/{recruit-seq}/applicants")
    public ResponseEntity<List<Applicants>> getApplicantList(@PathVariable(name = "recruit-seq") Long recruitSeq){
        return ResponseEntity.ok(positionService.getApplicants(recruitSeq));
    }



}
