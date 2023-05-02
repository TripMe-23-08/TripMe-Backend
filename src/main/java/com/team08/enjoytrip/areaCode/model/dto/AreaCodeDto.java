package com.team08.enjoytrip.areaCode.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AreaCodeDto {
    private int sidoCode;
    private String sidoName;
    private List<GugunInfoDto> relatedGugun;
}

