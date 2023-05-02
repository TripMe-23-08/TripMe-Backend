package com.team08.enjoytrip.areaCode.model.service;

import com.team08.enjoytrip.areaCode.model.dto.AreaCodeDto;
import com.team08.enjoytrip.areaCode.model.repository.AreaCodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaCodeServiceImpl implements AreaCodeService{
    private AreaCodeRepository areaCodeRepository;

    public AreaCodeServiceImpl(AreaCodeRepository areaCodeRepository) {
        this.areaCodeRepository = areaCodeRepository;
    }

    @Override
    public AreaCodeDto getAreaCode(int sidoCode) {
        return areaCodeRepository.findAreaCode(sidoCode);
    }

    @Override
    public List<AreaCodeDto> getAllAreaCodes() {
        return areaCodeRepository.findAllAreaCodes();
    }
}
