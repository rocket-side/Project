package com.rocket.rocket_project.introduction.controller;

import com.rocket.rocket_project.introduction.domain.response.CommentDto;
import com.rocket.rocket_project.introduction.domain.response.IntroductionDto;
import com.rocket.rocket_project.introduction.service.IntroductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/api/introduces")
public class IntroductionRestController {


    private final IntroductionService introductionService;

    /**
     * 해당 소개글 조회
     * @param recruitSeq
     * @return
     */
    @GetMapping("/{recruit-seq}")
    public ResponseEntity<IntroductionDto> getIntroduction(@PathVariable("recruit-seq") Long recruitSeq){
        return ResponseEntity.ok(introductionService.getIntroduction(recruitSeq));
    }

    @GetMapping("/{recruit-seq}/comments")
    public ResponseEntity<List<CommentDto>> getIntroductionComments(@PathVariable("recruit-seq") Long recruitSeq){
        return ResponseEntity.ok(introductionService.getComments(recruitSeq));
    }

}
