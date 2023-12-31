package com.rocket.rocket_project.introduction.controller;

import com.rocket.rocket_project.introduction.domain.response.CommentDto;
import com.rocket.rocket_project.introduction.domain.response.IntroductionDto;
import com.rocket.rocket_project.introduction.domain.response.IntroductionForCard;
import com.rocket.rocket_project.introduction.service.IntroductionService;
import com.rocket.rocket_project.recruit.domain.request.AccessUser;
import com.rocket.rocket_project.recruit.domain.request.PageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<PageDto<IntroductionForCard>> getIntroductions(@PageableDefault(size = 16) Pageable pageable,
                                                                      @RequestParam(value = "type", required = false) Long type,
                                                                      @RequestParam(value = "position", required = false) String position,
                                                                      @RequestParam(value = "field", required = false) Long field,
                                                                      @RequestBody AccessUser accessUser){
        Page<IntroductionForCard> introductionForCardList = introductionService.getIntroductionCards(field,type,pageable,accessUser.getMemberSeq());
        return  ResponseEntity.ok(PageDto.of(introductionForCardList,introductionForCardList.getContent()));

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
    @PostMapping("/isredirect/{comment-seq}")
    public ResponseEntity<Boolean> isRedirectUser(@PathVariable("comment-seq") Long commentSeq,
                                                  @RequestBody AccessUser accessUser){
        return ResponseEntity.ok(introductionService.isRedirectUser(commentSeq,accessUser.getMemberSeq()));
    }

    /**
     *  소개글의 접근하는 유저가 소개글 작성자(공고리더)인지 확인
     * @param recruitSeq
     * @param accessUser
     * @return
     */
    @PostMapping("/iswriter/{recruit-seq}")
    public ResponseEntity<Boolean> isIntroductionWriter(@PathVariable("recruit-seq") Long recruitSeq,
                                                        @RequestBody AccessUser accessUser){
        return ResponseEntity.ok(introductionService.isIntroductionWriter(recruitSeq,accessUser.getMemberSeq()));
    }

}
