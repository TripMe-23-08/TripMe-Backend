package com.team08.enjoytrip.tripRoute.model.dto;

import com.team08.enjoytrip.place.model.dto.TripPlaceDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class TripRouteDto {
    private int id;
    private String name;
    private Timestamp createdAt;
    private int userId;
    private String tripImgUrl;
    private List<TripPlaceDto> tripPlaces;
}
