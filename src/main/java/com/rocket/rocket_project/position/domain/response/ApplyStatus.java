package com.rocket.rocket_project.position.domain.response;

import com.rocket.rocket_project.position.entity.RecruitPositionApply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplyStatus {
    private Long positionSeq;
    private Long recruitSeq;
    private String name;
    private Integer applyCnt;
    private Integer wantCnt;

    public static class ApplyStatusBuilder {
        private Long positionSeq;
        private Long recruitSeq;
        private String name;
        private Integer applyCnt;
        private Integer wantCnt;

        public ApplyStatusBuilder getApplyCnt(List<RecruitPositionApply> applyCntList,Long positionSeq){
            this.applyCnt = (int) applyCntList.stream()
                    .filter(position -> Objects.equals(position.getPk().getPosition().getPositionSeq(), positionSeq))
                    .count();
            return this;
        }

    }

}
