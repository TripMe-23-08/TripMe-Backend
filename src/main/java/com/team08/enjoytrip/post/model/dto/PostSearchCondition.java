package com.team08.enjoytrip.post.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PostSearchCondition {
    private Integer userId;
    private Integer limitCount;
    private Integer offset;

    @Builder
    public PostSearchCondition(Integer userId, Integer limitCount, Integer offset) {
        this.userId = userId;
        this.limitCount = limitCount;
        this.offset = offset;
    }
}
