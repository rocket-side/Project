package com.rocket.rocket_project.introduction.domain.response;

import com.rocket.rocket_project.recruit.domain.response.Field;
import com.rocket.rocket_project.recruit.domain.response.Type;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IntroductionForCard {
    private Long recruitSeq;
    private String name;
    private Field field;
    private String info;
    private String status;

}
