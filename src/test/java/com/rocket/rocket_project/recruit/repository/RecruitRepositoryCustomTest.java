package com.rocket.rocket_project.recruit.repository;

import com.rocket.rocket_project.position.entity.Keep;
import com.rocket.rocket_project.recruit.domain.request.AccessUser;
import com.rocket.rocket_project.recruit.domain.request.RecruitLeader;
import com.rocket.rocket_project.recruit.domain.response.PositionForCards;
import com.rocket.rocket_project.recruit.entity.ProjectField;
import com.rocket.rocket_project.recruit.entity.ProjectType;
import com.rocket.rocket_project.recruit.entity.Recruit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
@ActiveProfiles("dev")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RecruitRepositoryCustomTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    RecruitRepository recruitRepository;
    @Autowired
    FieldRepository fieldRepository;

    Recruit recruit;
    ProjectField field;
    ProjectType type;
    List<Keep> keepList;
    Keep keep1;
    Keep keep2;



    @BeforeEach
    void setUp() {
        field = ProjectField.builder()
                .fieldSeq(1L)
                .name("패쎤")
                .build();

        type = ProjectType.builder()
                .typeSeq(2L)
                .name("프로젝트")
                .build();

        recruit = Recruit.builder()
                    .name("동물 사이드 프로젝트")
                    .status("모집중")
                    .leader(1L)
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now())
                    .createdAt(LocalDateTime.now())
                    .content("프로젝트 내용입니다.")
                    .info("동물 ~~~")
                    .field(field)
                    .type(type)
                    .build();

        keep1 =  Keep.builder()
                .pk(
                      Keep.Pk.builder()
                              .recruitSeq(recruit.getRecruitSeq())
                              .memberSeq(1L)
                              .build()
                )
                .build();

        keep2 =  Keep.builder()
                .pk(
                        Keep.Pk.builder()
                                .recruitSeq(recruit.getRecruitSeq())
                                .memberSeq(2L)
                                .build()
                )
                .build();

    }

    @Test
    void findAllBy() {
        Page<Recruit> recruitPage = recruitRepository.findAllBy(null,null,PageRequest.of(0,10));

//        List<Recruit> content = recruitPage.getContent();
//        for(Recruit recruit_result : content){
//            int result = recruit_result.getKeepList().size();
//            assertThat(result).isEqualTo(3);
//        }
        assertThat(recruitPage.getTotalElements()).isEqualTo(1);
    }

    @Test
    void findAllKeepList() {
        List<com.rocket.rocket_project.recruit.domain.response.Keep> keeps = recruitRepository.findAllKeepList(1L);
        assertThat(keeps.size()).isEqualTo(3);

    }

    @Test
    void findAllRecruitPosition() {
        List<PositionForCards> positions = recruitRepository.findAllRecruitPosition();
        assertThat(positions.size()).isEqualTo(3);
    }

    @Test
    void findRecruitByRecruitSeq(){
        RecruitLeader leaderSeq = recruitRepository.findRecruitLeaderByRecruitSeq(1L);
        Long value = leaderSeq.getLeader();
        assertThat(value).isEqualTo(1L);
    }
}