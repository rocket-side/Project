package com.rocket.rocket_project.skill_recruit.entity;

import com.rocket.rocket_project.recruit.entity.Recruit;
import com.rocket.rocket_project.skill.entity.Skill;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Skill_recruit")
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
        private Skill skillSeq;
        @JoinColumn(name = "recruit_seq",nullable = false)
        @ManyToOne
        private Recruit recruitSeq;
    }
}
