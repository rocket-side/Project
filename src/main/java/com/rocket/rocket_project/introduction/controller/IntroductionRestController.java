package com.rocket.rocket_project.introduction.controller;

import com.rocket.rocket_project.introduction.domain.response.CommentDto;
import com.rocket.rocket_project.introduction.domain.response.IntroductionDto;
import com.rocket.rocket_project.introduction.service.IntroductionService;
import com.rocket.rocket_project.recruit.domain.request.AccessUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    /**
     *  해당 소개글의 모든 댓글 조회
     * @param recruitSeq
     * @return
     */
    @GetMapping("/{recruit-seq}/comments")
    public ResponseEntity<List<CommentDto>> getIntroductionComments(@PathVariable("recruit-seq") Long recruitSeq){
        return ResponseEntity.ok(introductionService.getComments(recruitSeq));
    }

    /**
     * 댓글에 접근하는 유저가 댓글작성자 인지 확인
     * @param commentSeq
     * @param accessUser
     * @return
     */
    @GetMapping("/isredirect/{comment-seq}")
    public ResponseEntity<Boolean> isRedirectUser(@PathVariable("comment-seq") Long commentSeq,
                                                  @Valid @RequestBody AccessUser accessUser){
        return ResponseEntity.ok(introductionService.isRedirectUser(commentSeq,accessUser.getMemberSeq()));
    }

}
