package com.rocket.rocket_project.recruit.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitCard {

    private Long recruitSeq;

    private String name;

    private Type type;

    private Field field;

    private List<PositionForCards> positionForCards;

    private Boolean isKeep;

    public RecruitCard(Long recruitSeq, String name, Type type, Field field, Boolean isKeep) {
        this.recruitSeq = recruitSeq;
        this.name = name;
        this.type = type;
        this.field = field;
        this.isKeep = isKeep;
    }

    public static class RecruitCardBuilder {
        private Long recruitSeq;
        private String name;
        private Type type;
        private Field field;
        private List<PositionForCards> positionForCards;
        private Boolean isKeep;

        public RecruitCardBuilder isKeepFromKeepList(List<Keep> keepList, Long recruitSeq, Long accessUser) {
            this.isKeep = keepList.stream()
                    .anyMatch(keep ->
                            Objects.equals(keep.getRecruitSeq(), recruitSeq) &&
                                    Objects.equals(keep.getMemberSeq(), accessUser));
            return this;
        }

        public RecruitCardBuilder recruitPositionList(List<PositionForCards> positionList , Long recruitSeq){
            this.positionForCards = positionList.stream()
                    .filter(position -> Objects.equals(position.getRecruitSeq(), recruitSeq))
                    .collect(Collectors.toList());
            return this;

        }

    }
}


