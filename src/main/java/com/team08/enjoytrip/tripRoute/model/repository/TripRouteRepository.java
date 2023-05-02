package com.team08.enjoytrip.tripRoute.model.repository;

import com.team08.enjoytrip.tripRoute.model.dto.TripPlaceDto;
import com.team08.enjoytrip.tripRoute.model.dto.TripRouteDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TripRouteRepository {
    List<TripRouteDto> getAll();
    TripRouteDto get(int id);
    void create(TripRouteDto tripRouteDto);
    void update(TripRouteDto tripRouteDto);
    void delete(int id);
    List<TripPlaceDto> getAllPlacesByRouteId(int id);

}
