package com.team08.enjoytrip.post.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PostRequestDto {
    private String title;
    private String content;
    private int tripRouteId;
    private int userId;
}
