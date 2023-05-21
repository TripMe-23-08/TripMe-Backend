package com.team08.enjoytrip.tripRoute.model.dto;

import java.sql.Timestamp;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@NoArgsConstructor
public class TripRouteDto {
    private int id;
    private String name;
    private Timestamp createdAt;
    private int userId;
    private String tripImgUrl;
    private List<TripPlaceDto> tripPlaces;


   @Builder
    public TripRouteDto(int id, String name, Timestamp createdAt, int userId, String tripImgUrl,
                        List<TripPlaceDto> tripPlaces) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.userId = userId;
        this.tripImgUrl = tripImgUrl;
        this.tripPlaces = tripPlaces;
    }
}
