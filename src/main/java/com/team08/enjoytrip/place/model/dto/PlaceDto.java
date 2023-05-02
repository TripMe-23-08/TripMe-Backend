package com.team08.enjoytrip.place.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Setter
@Getter
public class PlaceDto {
    private int id;
    private String name;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String address;
    private String category;
    private String imgUrl;
    private String imgUrl2;
    private int sidoCode;
    private int gugunCode;
    @Builder
    public PlaceDto(int id, String name, BigDecimal longitude, BigDecimal latitude, String address, String category, String imgUrl, String imgUrl2, int sidoCode, int gugunCode) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.category = category;
        this.imgUrl = imgUrl;
        this.imgUrl2 = imgUrl2;
        this.sidoCode = sidoCode;
        this.gugunCode = gugunCode;
    }
}
