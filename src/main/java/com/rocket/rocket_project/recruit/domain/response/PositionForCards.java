package com.rocket.rocket_project.recruit.domain.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("position-genre")
public class PositionForCards {
    private Long positionSeq;
    private String name;

    private Long recruitSeq;
}
