package com.rocket.rocket_project.community.controller;

import com.rocket.rocket_project.community.dto.request.CommunityCommentRegisterDto;
import com.rocket.rocket_project.community.dto.request.CommunityRegisterDto;
import com.rocket.rocket_project.community.dto.response.CommunityResponseDto;
import com.rocket.rocket_project.community.entity.Community;
import com.rocket.rocket_project.community.entity.CommunityComment;
import com.rocket.rocket_project.community.service.CommunityCommentService;
import com.rocket.rocket_project.community.service.CommunityService;
import com.rocket.rocket_project.recruit.domain.request.PageDto;
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

    private final CommunityCommentService communityCommentService;

    @ApiOperation(value = "커뮤니티 페이지 조회", notes = "전체 커뮤니티 페이지 조회")
    @GetMapping()
    public ResponseEntity<PageDto<Community>> getPageCommunity(@RequestParam(required = false, defaultValue = "0"
    , value = "page") int pageNo,
                                                               @RequestParam(required = false, defaultValue = "createAt",
                                                            value = "criteria") String criteria) {
        return ResponseEntity.status(HttpStatus.OK).body(communityService.getPageCommunity(pageNo, criteria));
    }

    @ApiOperation(value = "댓글 조회", notes = "게시글의 seq로 댓글을 조회합니다.")
    @GetMapping("/{post_seq}/comments")
    public ResponseEntity<PageDto<CommunityComment>> getComments(@RequestParam(required = false, defaultValue = "0",
    value = "page") int pageNo,
                                                              @RequestParam(required = false, defaultValue = "createAt",
                                                              value = "criteria") String criteria,
                                                              @PathVariable Long post_seq) {
        return ResponseEntity.status(HttpStatus.OK).body(communityCommentService.findAll(pageNo, criteria, post_seq));
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

    @ApiOperation(value = "댓글 등록", notes = "댓글을 등록합니다.")
    @PostMapping("/{post_seq}/comments/register")
    public ResponseEntity<Void> registerComment(@PathVariable Long post_seq, @RequestBody CommunityCommentRegisterDto dto) {
        communityCommentService.registerCommunityComment(post_seq, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "댓글 수정", notes = "댓글seq,게시글seq, dto를 받아 수정합니다.")
    @PatchMapping("/{post_seq}/comments/update/{comment_seq}")
    public ResponseEntity<Void> updateComment(@PathVariable Long post_seq, @PathVariable Long comment_seq, @RequestBody
                                              CommunityCommentRegisterDto dto) {
        communityCommentService.updateCommunityComment(post_seq, dto, comment_seq);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "댓글 삭제", notes = "댓글의 seq를 받아 해당 댓글을 삭제합니다.")
    @DeleteMapping("/comments/delete/{comment_seq}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long comment_seq) {
        communityCommentService.deleteComment(comment_seq);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "게시글 좋아요 업데이트", notes = "게시글 seq를 받아 해당 게시글의 좋아요를 1 상승시킵니다.")
    @PatchMapping("/{post_seq}/like")
    public ResponseEntity<Void> likeUpdate(@PathVariable Long post_seq) {
        communityService.updateLike(post_seq);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
