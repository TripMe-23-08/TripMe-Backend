package com.team08.enjoytrip.place.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class LikePlaceDto {
    private int id;
    private int userId;
    private int placeId;
}
