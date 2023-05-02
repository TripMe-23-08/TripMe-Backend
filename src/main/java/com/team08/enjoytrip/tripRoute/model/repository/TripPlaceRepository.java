package com.team08.enjoytrip.tripRoute.model.repository;

import com.team08.enjoytrip.tripRoute.model.dto.TripPlaceDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TripPlaceRepository {
    void create(TripPlaceDto tripPlaceDto);
}
