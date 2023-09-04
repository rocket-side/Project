package com.rocket.rocket_project.recruit.controller;

import com.rocket.rocket_project.recruit.domain.request.AccessUser;
import com.rocket.rocket_project.recruit.domain.response.RecruitCard;
import com.rocket.rocket_project.recruit.domain.response.RecruitDto;
import com.rocket.rocket_project.recruit.domain.response.RecruitTag;
import com.rocket.rocket_project.recruit.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/api/recruits")
public class RecruitRestController {

    private final RecruitService recruitService;

    /**
     *  공고목록조회 -  카드박스에 들어갈 내용만 넣어둔 리스트
     * @param pageable
     * @param type
     * @param position
     * @param field
     * @param accessUser
     * @return Page<RecruitCard>
     */
    @GetMapping()
    public ResponseEntity<Page<RecruitCard>> getRecruits(Pageable pageable,
                                                         @RequestParam(value = "type", required = false) Long type,
                                                         @RequestParam(value = "position", required = false) String position,
                                                         @RequestParam(value = "field", required = false) Long field,
                                                         @RequestBody AccessUser accessUser
                                                         ) {
        Page<RecruitCard> recruitCards = recruitService.getRecruitCards(field,type,pageable,accessUser.getMemberSeq());
        return ResponseEntity.ok(recruitCards);
    }

    /**
     * 공고 목록 조회용 태그목록 ->  프로젝트 유형/분야/포지션 태그
     * @return List<RecruitTag>
     */
    @GetMapping("/types")
    public ResponseEntity<RecruitTag> getRecruitTagList(){
        return ResponseEntity.ok(recruitService.getRecruitTagList());
    }

    /**
     * 해당 공고글 조회
     * @param recruitSeq
     * @return
     */
    @GetMapping("/{recruit-seq}")
    public ResponseEntity<RecruitDto> getRecruit(@PathVariable(name = "recruit-seq") Long recruitSeq) {
        return ResponseEntity.ok(recruitService.getRecruit(recruitSeq));
    }

    @GetMapping("/isgroupleader/{recruit-seq}")
    public ResponseEntity<Boolean> isGroupLeader(@PathVariable(name = "recruit-seq") Long recruitSeq,
                                                 @Valid @RequestBody AccessUser accessUser) {
        return ResponseEntity.ok(recruitService.isGroupLeader(recruitSeq,accessUser));
    }


}
