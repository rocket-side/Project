package com.rocket.rocket_project.community.dto.request;

import lombok.Getter;

@Getter
public class CommunityRegisterDto {

    private String title;

    private String content;

    private Long memberSeq;

    private Long categorySeq;
}
