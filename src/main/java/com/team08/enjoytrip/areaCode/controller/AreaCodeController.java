package com.team08.enjoytrip.areaCode.controller;

import com.team08.enjoytrip.areaCode.model.dto.AreaCodeDto;
import com.team08.enjoytrip.areaCode.model.service.AreaCodeService;
import com.team08.enjoytrip.common.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@CrossOrigin
public class AreaCodeController {
    private AreaCodeService areaCodeService;

    public AreaCodeController(AreaCodeService areaCodeService) {
        this.areaCodeService = areaCodeService;
    }

    @GetMapping("/area-codes")
    public ResponseEntity<ResponseDto> searchAreaCodes(@RequestParam Map<String, String> map) {
        log.debug("[GET] /area-codes "+map.get("sido"));
        String sido = map.get("sido");
        if (sido!=null) {
            AreaCodeDto areaCodeDto = areaCodeService.getAreaCode(Integer.parseInt(sido));
            return new ResponseEntity<>(new ResponseDto("시도 번호" + sido + "에 해당하는 구군 조회", areaCodeDto), HttpStatus.OK);
        } else {
            List<AreaCodeDto> areaCodes = areaCodeService.getAllAreaCodes();
            return new ResponseEntity<>(new ResponseDto("모든 지역 번호 조회", areaCodes), HttpStatus.OK);
        }
    }
}
