package com.rocket.rocket_project.introduction.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Introduction {

    private Long recruitSeq;
    private Integer likeCount;
    private LocalDateTime createdAt;
    private String content;



}

