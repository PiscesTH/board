package com.th.board.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Pics {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ipics;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ipost")
    private Posts posts;

    @NotNull
    @Column(length = 2100)
    private String pic;
}
