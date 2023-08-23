package com.rocket.rocket_project.recruit.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("recruit-card")
public class RecruitCard {

    @JsonProperty("recruit_seq")
    private Long recruitSeq;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("field")
    private Field field;

    @JsonProperty("position-genre")
    private List<PositionGenre> positionGenres;

    @JsonProperty("isKeep")
    private Boolean isKeep;




}
