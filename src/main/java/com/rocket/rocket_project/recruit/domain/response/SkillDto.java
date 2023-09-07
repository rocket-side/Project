package com.rocket.rocket_project.recruit.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto {
    private Long recruitSeq;
    private Long skillSeq;
    private String name;
}
