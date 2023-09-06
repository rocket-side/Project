package com.rocket.rocket_project.community.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommunityResponseDto {

    private Long postSeq;

    private LocalDateTime createAt;

    private Long memberSeq;

    private Integer viewCount;

    private Integer likeCount;

    private String content;

    private String title;

    private CategoryResponseDto categoryResponseDto;

}
