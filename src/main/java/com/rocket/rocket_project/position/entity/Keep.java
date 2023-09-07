package com.rocket.rocket_project.position.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rocket.rocket_project.recruit.entity.Recruit;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Keep")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Keep {
    @EmbeddedId
    Pk pk;

    @MapsId("recruitSeq")
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "recruit_seq",nullable = false)
    private Recruit recruitSeq;

    @Embeddable
    @EqualsAndHashCode
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @Column(name = "recruit_seq",nullable = false)
        private Long recruitSeq;
        @Column(name = "member_seq",nullable = false)
        private Long memberSeq;
    }

    public void setRecruitSeq(Recruit recruit){
        if (this.recruitSeq != null){
            this.recruitSeq.removeKeep(this);
        }
        this.recruitSeq=recruit;
        recruit.addKeep(this);
    }

//    @Builder
//    public Keep(Pk pk, Recruit recruitSeq) {
//        this.pk = pk;
//        this.recruitSeq = recruitSeq;
//    }
}
