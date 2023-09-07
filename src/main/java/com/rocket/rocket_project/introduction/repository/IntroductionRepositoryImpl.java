package com.rocket.rocket_project.introduction.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.rocket.rocket_project.introduction.domain.response.IntroductionForCard;
import com.rocket.rocket_project.introduction.entity.Introduction;
import com.rocket.rocket_project.introduction.entity.QIntroduction;
import com.rocket.rocket_project.recruit.domain.response.Field;
import com.rocket.rocket_project.recruit.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class IntroductionRepositoryImpl extends QuerydslRepositorySupport implements IntroductionRepositoryCustom {
    public IntroductionRepositoryImpl() {super(Introduction.class);}

    QIntroduction introduction = QIntroduction.introduction;
    QRecruit recruit = QRecruit.recruit;
    QProjectType type = QProjectType.projectType;
    QProjectField field = QProjectField.projectField;




    @Override
    public Page<Introduction> getIntroductions(Long field_pm, Long type_pm , Pageable pageable){
        JPAQuery<Introduction> content = (JPAQuery<Introduction>) from(introduction)
                .innerJoin(introduction.recruit,recruit)
                .innerJoin(recruit.projectType,type);
        if (field_pm != null) {
            content.where(recruit.projectField.fieldSeq.eq(field_pm));
        }
        if (type_pm != null) {
            content.where(type.typeSeq.eq(type_pm));
        }
        //    private BooleanExpression eqPosition(Long position_pm) {
//        return position_pm != null ? positionGenre.positionGenreSeq.eq(position_pm) : null;
//    }

        List<Introduction> result = content.fetch();
        return new PageImpl<>(result, pageable,content.stream().count());
    }

}
