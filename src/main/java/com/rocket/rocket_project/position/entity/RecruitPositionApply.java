package com.rocket.rocket_project.position.entity;

import com.rocket.rocket_project.recruit.entity.Recruit;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RECRUIT_POSITION_APPLY")
@NoArgsConstructor
@Getter
public class RecruitPositionApply {
    @EmbeddedId
    Pk pk;

    @Column(name = "is_accept",nullable = false)
    private String isAccept;

    @Embeddable
    @EqualsAndHashCode
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @Column(name = "member_seq",nullable = false)
        private Long memberSeq;
        @JoinColumn(name = "position_seq",nullable = false)
        @ManyToOne
        private Position positionSeq;
        @JoinColumn(name = "recruit_seq",nullable = false)
        @ManyToOne
        private Recruit recruitSeq;
    }
}
