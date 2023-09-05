package com.rocket.rocket_project.position.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitCrew {
    private Long memberSeq;
    private Long recruitSeq;
    private Long positionSeq;
    private String positionName;
    private String role;

    public RecruitCrew(Long memberSeq, Long recruitSeq, Long positionSeq, String positionName) {
        this.memberSeq = memberSeq;
        this.recruitSeq = recruitSeq;
        this.positionSeq = positionSeq;
        this.positionName = positionName;
    }

    public void setCrewRole(Boolean isLeader){
        if(isLeader)  this.role = "ROLE_LEADER";
        else this.role = "ROLE_MEMBER" ;

    }


}
