package com.team08.enjoytrip.place.model.repository;

import com.team08.enjoytrip.place.model.dto.TripPlaceDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TripPlaceRepository {
    void create(TripPlaceDto tripPlaceDto);
}
