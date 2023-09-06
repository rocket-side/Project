package com.rocket.rocket_project.community.controller;

import com.rocket.rocket_project.community.dto.request.CommunityRegisterDto;
import com.rocket.rocket_project.community.dto.response.CommunityResponseDto;
import com.rocket.rocket_project.community.entity.Community;
import com.rocket.rocket_project.community.service.CommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequiredArgsConstructor
@RequestMapping("/project/api/community")
public class CommunityController {

    private final CommunityService communityService;

    @ApiOperation(value = "커뮤니티 페이지 조회", notes = "전체 커뮤니티 페이지 조회")
    @GetMapping()
    public ResponseEntity<Page<Community>> getPageCommunity(@RequestParam(required = false, defaultValue = "0"
    , value = "page") int pageNo,
                                                            @RequestParam(required = false, defaultValue = "createAt",
                                                            value = "criteria") String criteria) {
        return ResponseEntity.status(HttpStatus.OK).body(communityService.getPageCommunity(pageNo, criteria));
    }

    @ApiOperation(value = "커뮤니티 글 작성", notes = "게시글 작성 후 저장")
    @PostMapping("/register")
    public ResponseEntity<Void> registerCommunity(@RequestBody CommunityRegisterDto dto) {
        communityService.registerCommunity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "커뮤니티 조회", notes = "게시글 seq를 이용하여 게시글 조회")
    @GetMapping("/{post_seq}")
    public ResponseEntity<CommunityResponseDto> getCommunity(@PathVariable Long post_seq) {
        return ResponseEntity.status(HttpStatus.OK).body(communityService.getCommunity(post_seq));
    }

    @ApiOperation(value = "커뮤니티 수정", notes = "게시글 seq와 dto를 입력받아 수정합니다.")
    @PatchMapping("/update/{post_seq}")
    public ResponseEntity<Void> updateCommunity(@PathVariable Long post_seq, @RequestBody CommunityRegisterDto dto) {
        communityService.updateCommunity(post_seq, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "커뮤니티 삭제", notes = "게시글 seq를 받아 해당 게시글을 삭제합니다.")
    @DeleteMapping("/delete/{post_seq}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long post_seq) {
        communityService.deleteCommunity(post_seq);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
