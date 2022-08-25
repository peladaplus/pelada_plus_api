package com.athenas.pelada_plus_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "pld_group")
public class Group implements Serializable {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String image;
    private Frequency frequency;
    private Days days;
    private Modality modality;
    private Assessment assessment;
}

enum Frequency {
    monthly,
    biweekly,
    weekly,
}

enum Days {
    monday,
    tuesday,
    wednesday,
    thursday,
    friday,
    saturday,
    sunday
}

enum Modality {
    soccer,
    indoorSoccer,
    society
}

enum Assessment {
    selfEvaluation,
    moderator
}