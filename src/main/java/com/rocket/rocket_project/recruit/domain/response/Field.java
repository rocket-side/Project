package com.rocket.rocket_project.recruit.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Field {
    private Long fieldSeq;
    private String name;
}
