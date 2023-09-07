package com.rocket.rocket_project.recruit.repository;

import com.querydsl.core.types.Projections;
import com.rocket.rocket_project.recruit.domain.response.SkillDto;
import com.rocket.rocket_project.recruit.entity.QSkill;
import com.rocket.rocket_project.recruit.entity.QSkillRecruit;
import com.rocket.rocket_project.recruit.entity.Skill;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class SkillRepositoryImpl extends QuerydslRepositorySupport implements SkillRepositoryCustom {

    public SkillRepositoryImpl() {super(Skill.class);}
    QSkillRecruit skillRecruit = QSkillRecruit.skillRecruit;
    QSkill skill = QSkill.skill;
    @Override
    public List<SkillDto> getRecruitSkills(Long recruitSeq) {
        return from(skillRecruit)
                .leftJoin(skillRecruit.pk.skill,skill)
                .on(skillRecruit.pk.skill.skillSeq.eq(skill.skillSeq))
                .where(skillRecruit.pk.recruit.recruitSeq.eq(recruitSeq))
                .select(Projections.constructor(SkillDto.class,
                        skillRecruit.pk.recruit.recruitSeq,
                        skillRecruit.pk.skill.skillSeq,
                        skill.name))
                .fetch();
    }
}
