package com.team08.enjoytrip.areaCode.model.service;

import com.team08.enjoytrip.areaCode.model.dto.AreaCodeDto;

import java.util.List;

public interface AreaCodeService {
    AreaCodeDto getAreaCode(int sidoCode);
    List<AreaCodeDto> getAllAreaCodes();
}
