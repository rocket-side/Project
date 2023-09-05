package com.rocket.rocket_project.position.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class PositionCount {

    private Long positionSeq;
    private Long recruitSeq;
    private Integer count;
    private String name;

    public PositionCount(Long positionSeq, Long recruitSeq, Integer count, String name) {
        this.positionSeq = positionSeq;
        this.recruitSeq = recruitSeq;
        this.count = count;
        this.name = name;
    }
}
