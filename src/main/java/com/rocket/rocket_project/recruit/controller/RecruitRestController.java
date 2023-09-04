package com.rocket.rocket_project.recruit.controller;

import com.rocket.rocket_project.recruit.domain.request.AccessUser;
import com.rocket.rocket_project.recruit.domain.response.RecruitCard;
import com.rocket.rocket_project.recruit.domain.response.RecruitTag;
import com.rocket.rocket_project.recruit.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.util.List;

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
     * 공고 목록 사이트에서 사용할 태그목록 ->  프로젝트 유형/분야/포지션 태그
     * @return List<RecruitTag>
     */
    @GetMapping("/types")
    public ResponseEntity<List<RecruitTag>> getRecruitTagList(){
        return ResponseEntity.ok(recruitService.getRecruitTagList());
    }


}
