package com.rocket.rocket_project.recruit.controller;

import com.rocket.rocket_project.recruit.domain.response.Field;
import com.rocket.rocket_project.recruit.domain.response.RecruitCard;
import com.rocket.rocket_project.recruit.domain.response.Type;
import com.rocket.rocket_project.recruit.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/api/recruits")
public class RecruitRestController {

    private final RecruitService recruitService;


    @GetMapping()
    public ResponseEntity<List<RecruitCard>> getRecruits(@RequestParam(value = "page", required = false) Integer page,
                                                         @RequestParam(value = "type", required = false) Integer type,
                                                         @RequestParam(value = "position", required = false) String position,
                                                         @RequestParam(value = "field", required = false) Integer field
                                                         ) {

        return ResponseEntity.ok(new ArrayList<RecruitCard>(Arrays.asList(new RecruitCard(1L,
                "name",
                new Type(1L,"스터디"),
                new Field(1L,"패션"),
                null,
                false))));
//        return ResponseEntity.ok("string");
    }


}
