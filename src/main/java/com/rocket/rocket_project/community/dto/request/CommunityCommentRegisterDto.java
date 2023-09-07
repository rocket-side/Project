package com.rocket.rocket_project.community.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommunityCommentRegisterDto {

    private LocalDateTime createAt;

    private Long memberSeq;

    private String content;

    private Long commentSeq;

}
