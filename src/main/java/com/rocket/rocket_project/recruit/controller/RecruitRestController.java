package com.rocket.rocket_project.recruit.controller;

import com.rocket.rocket_project.recruit.domain.request.AccessUser;
import com.rocket.rocket_project.recruit.domain.response.Field;
import com.rocket.rocket_project.recruit.domain.response.InfoForCards;
import com.rocket.rocket_project.recruit.domain.response.RecruitCard;
import com.rocket.rocket_project.recruit.domain.response.Type;
import com.rocket.rocket_project.recruit.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/api/recruits")
public class RecruitRestController {

    private final RecruitService recruitService;

    @GetMapping()
    public ResponseEntity<Page<RecruitCard>> getRecruits(Pageable pageable,
                                                         @RequestParam(value = "type", required = false) Long type,
                                                         @RequestParam(value = "position", required = false) String position,
                                                         @RequestParam(value = "field", required = false) Long field,
                                                         @RequestBody AccessUser accessUser
                                                         ) {
        Page<RecruitCard> recruitCards = recruitService.getRecruitCards(field,type,pageable,accessUser.getMemberSeq());
        return ResponseEntity.ok(recruitCards);
//        return ResponseEntity.ok("string");
    }


}
