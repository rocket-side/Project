package com.rocket.rocket_project.recruit.domain.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    @Schema(description = "공고유형번호", defaultValue = "typeId")
    private Long typeSeq;
    @Schema(description = "공고유형이름", defaultValue = "typeName")
    private  String name;
}
