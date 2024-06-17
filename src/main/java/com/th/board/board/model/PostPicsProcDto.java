package com.th.board.board.model;

import com.th.board.entity.Posts;
import lombok.Data;

@Data
public class PostPicsProcDto {
    private Posts post;
    private String pic;
}
