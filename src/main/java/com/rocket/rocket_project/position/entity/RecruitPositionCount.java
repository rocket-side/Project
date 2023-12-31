package com.rocket.rocket_project.position.entity;

import com.rocket.rocket_project.recruit.entity.Recruit;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Recruit_Position_Count")
@NoArgsConstructor
@Getter
public class RecruitPositionCount {
    @EmbeddedId
    Pk pk;

    @Column(nullable = false)
    private Integer count;

    @Embeddable
    @EqualsAndHashCode
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @JoinColumn(name = "position_seq",nullable = false)
        @ManyToOne
        private Position position;
        @JoinColumn(name = "recruit_seq",nullable = false)
        @ManyToOne
        private Recruit recruit;
    }
}
