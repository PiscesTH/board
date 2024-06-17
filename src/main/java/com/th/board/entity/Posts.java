package com.th.board.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Posts extends BaseEntity{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ipost;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "iuser")
    private User user;

    @NotNull
    @Column(length = 100)
    private String title;

    @NotNull
    @Column(length = 500)
    private String contents;

    @NotNull
    @Column(length = 2100)
    private String thumbNail;
}
