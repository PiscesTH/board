package com.th.board.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Posts {
    @Id
    @Column(columnDefinition = "BIGINT UNSIGHED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ipost;

    @NotNull
    @Column(length = 100)
    private String title;

    @NotNull
    @Column(length = 100)
    private String contents;
}
