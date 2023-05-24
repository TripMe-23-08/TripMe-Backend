package com.team08.enjoytrip.place.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HistoryPlaceRepository {
    void setPlaceHistory(@Param("user_id") int userId, @Param("place_id") int placeId);
}
