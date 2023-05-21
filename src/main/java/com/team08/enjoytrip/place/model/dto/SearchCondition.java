package com.team08.enjoytrip.place.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchCondition {
    private String sidoCode;
    private String gugunCode;
    private String category;
    private String searchKeyword;

    @Builder
    public SearchCondition(String sidoCode, String gugunCode, String category, String searchKeyword) {
        this.sidoCode = sidoCode;
        this.gugunCode = gugunCode;
        this.category = category;
        this.searchKeyword = searchKeyword;
    }
}
