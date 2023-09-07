package com.rocket.rocket_project.recruit.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Field {
    private Long fieldSeq;
    private String name;

    public Field(Long fieldSeq, String name) {
        this.fieldSeq = fieldSeq;
        this.name = name;
    }
}
