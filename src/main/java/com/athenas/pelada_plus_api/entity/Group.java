package com.athenas.pelada_plus_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Group implements Serializable {

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