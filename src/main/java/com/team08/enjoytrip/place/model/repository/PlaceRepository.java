package com.team08.enjoytrip.place.model.repository;

import com.team08.enjoytrip.place.model.dto.PlaceDto;

import com.team08.enjoytrip.place.model.dto.PlaceSearchCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceRepository {
    PlaceDto findById(int id);
    List<PlaceDto> findAll(PlaceSearchCondition searchCondition);

}
