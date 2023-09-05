package com.rocket.rocket_project.introduction.controller;

import com.rocket.rocket_project.introduction.service.IntroductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/api/introduces")
public class IntroductionRestController {

    private final IntroductionService introductionService;

//    @GetMapping("/{recruit-seq}")
//    public ResponseEntity<Introduction> getIntroduction(Long recruitSeq){
//
//    }

}
