package com.team08.enjoytrip.place.model.repository;

import com.team08.enjoytrip.place.model.dto.LikePlaceDto;
import com.team08.enjoytrip.place.model.dto.PlaceDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Mapper
public interface LikePlaceRepository {
    void save(LikePlaceDto likePlaceDto);
    List<PlaceDto> findAllByUserId(int userId) throws SQLIntegrityConstraintViolationException;

    void delete(int id);

    LikePlaceDto findById(int id);
}
