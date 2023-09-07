package com.rocket.rocket_project.recruit.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Skill_Recruit")
@NoArgsConstructor
@Getter
public class SkillRecruit {
    @EmbeddedId
    private Pk pk;

    @Embeddable
    @EqualsAndHashCode
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pk implements Serializable {
        @JoinColumn(name = "skill_seq",nullable = false)
        @ManyToOne
        private Skill skill;
        @JoinColumn(name = "recruit_seq",nullable = false)
        @ManyToOne
        private Recruit recruit;
    }
}
