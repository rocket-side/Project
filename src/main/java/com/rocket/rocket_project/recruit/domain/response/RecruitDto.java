package com.rocket.rocket_project.recruit.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitDto {
    private Long recruitSeq;

    private String name;

    private String status;

    private Long leader;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createdAt;

    private String content;

    private String info;

    private Field projectField;

    private Type projectType;

    private Integer keepCount;

    private List<SkillDto> skills;
}
