package com.team08.enjoytrip.tripRoute.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TripPlaceDto {
    private int id;
    private int placeId;
    private int tripRouteId;
    private int tripDay;
    private int tripOrder;
}
