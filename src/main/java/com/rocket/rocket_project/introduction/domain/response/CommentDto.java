package com.rocket.rocket_project.introduction.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rocket.rocket_project.introduction.entity.CommentIntroduction;
import com.rocket.rocket_project.recruit.entity.Recruit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long commentSeq;
    private Long memberSeq;
    private Long recruitSeq;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createAt;
    private String content;
    private List<CommentDto> ReplyList;

    public CommentDto(Long commentSeq, Long memberSeq, Long recruitSeq, LocalDateTime createAt, String content) {
        this.commentSeq = commentSeq;
        this.memberSeq = memberSeq;
        this.recruitSeq = recruitSeq;
        this.createAt = createAt;
        this.content = content;
    }
}
