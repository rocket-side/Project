package com.rocket.rocket_project.position.entity;

import com.rocket.rocket_project.recruit.entity.Recruit;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Keep")
@NoArgsConstructor
@Getter
public class Keep {
    @EmbeddedId
    Pk pk;

    @Embeddable
    @EqualsAndHashCode
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @JoinColumn(name = "recruit_seq",nullable = false)
        @ManyToOne
        private Recruit recruitSeq;
        @Column(name = "member_seq",nullable = false)
        private Integer memberSeq;
    }

}
