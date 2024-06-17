package com.th.board.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class User extends BaseEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iuser;

    @NotNull
    @Column
    private String uid;

    @NotNull
    @Column
    private String upw;

    @NotNull
    @Column
    private String nickname;
}
