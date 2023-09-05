package com.rocket.rocket_project.introduction.controller;

import com.rocket.rocket_project.introduction.domain.response.IntroductionDto;
import com.rocket.rocket_project.introduction.service.IntroductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/api/introduces")
public class IntroductionRestController {

    private final IntroductionService introductionService;

    @GetMapping("/{recruit-seq}")
    public ResponseEntity<IntroductionDto> getIntroduction(@PathVariable("recruit-seq") Long recruitSeq){
        return ResponseEntity.ok(introductionService.getIntroduction(recruitSeq));
    }

}
