package com.rocket.rocket_project.recruit.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoForCards {
    private Long recruitSeq;
    private String name;
    private Type type;
    private Field field;
    private List<Keep> isKeep;

}
