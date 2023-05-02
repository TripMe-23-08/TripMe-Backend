package com.team08.enjoytrip.areaCode.model.repository;

import com.team08.enjoytrip.areaCode.model.dto.AreaCodeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaCodeRepository {
    List<AreaCodeDto> findAllAreaCodes();
    AreaCodeDto findAreaCode(int sidoCode);
}
