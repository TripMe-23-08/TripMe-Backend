package com.team08.enjoytrip.post.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@Getter
@Setter
public class LikePostDto {
    private int id;
    private int userId;
    private int postId;
    private Timestamp createdAt;
}
