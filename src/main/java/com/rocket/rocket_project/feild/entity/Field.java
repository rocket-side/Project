package com.rocket.rocket_project.feild.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Field")
@NoArgsConstructor
@Getter
public class Field {
    @Id
    @Column(name = "field_seq")
    private Integer fieldSeq;

    @Column
    private String name;
}
