package com.rocket.rocket_project.recruit.domain.response;

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
public class RecruitTag {

    private List<Type> types;

    private List<Field> fields;

    private List<Position> positions;

}
