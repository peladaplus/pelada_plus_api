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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String image;
    private String frequency;
    private boolean selfEvaluation;
    private GameType gameType;
}

enum GameType {
    soccer,
    indoorSoccer,
    society,
}