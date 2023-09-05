package com.rocket.rocket_project.position.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Applicants {

    private Long memberSeq;
    private Long recruitSeq;
    private Long positionSeq;
    private String name;
    private String isAccept;
}
