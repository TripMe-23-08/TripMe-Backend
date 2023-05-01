package com.team08.enjoytrip.place.model.repository;

import com.team08.enjoytrip.place.model.dto.PlaceDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlaceRepository {
    PlaceDto findById();
}
