package com.th.board.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Posts {
    @Id
    @Column(columnDefinition = "BIGINT UNSIGHED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ipost;


}
