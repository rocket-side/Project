package com.rocket.rocket_project.introduction.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rocket.rocket_project.position.domain.response.RecruitCrew;
import com.rocket.rocket_project.recruit.domain.response.RecruitDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IntroductionDto {

    private RecruitDto recruit;
    private Integer likeCount;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    private String content;

    private List<RecruitCrew> recruitCrews;



}

