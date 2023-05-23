package com.team08.enjoytrip.place.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PlaceSearchCondition {
    private String sidoCode;
    private String gugunCode;
    private String category;
    private String searchKeyword;
    private Integer limitCount;
    private String onlyWithImage;
    private Integer offset;

    @Builder
    public PlaceSearchCondition(String sidoCode, String gugunCode, String category, String searchKeyword, Integer limitCount, String onlyWithImage, Integer offset) {
        this.sidoCode = sidoCode;
        this.gugunCode = gugunCode;
        this.category = category;
        this.searchKeyword = searchKeyword;
        this.limitCount = limitCount;
        this.onlyWithImage = onlyWithImage;
        this.offset = offset;
    }
}
