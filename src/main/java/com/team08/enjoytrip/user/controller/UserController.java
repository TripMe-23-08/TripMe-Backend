package com.team08.enjoytrip.user.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.user.model.dto.UserDto;
import com.team08.enjoytrip.user.model.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseDto> searchUserInfo(@PathVariable int userId) {
        log.debug("[GET] /users/{userId} : " + userId);
        UserDto userDto = userService.get(userId);
        return new ResponseEntity<>(new ResponseDto("유저 정보 조회", userDto), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResponseDto> updateUserInfo(@RequestBody UserDto userDto) {
        log.debug("[PUT] /users/{userId} : " + userDto.getId());
        userService.update(userDto);
        return new ResponseEntity<>(new ResponseDto("유저 정보 수정 성공", null), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable int userId){
        log.debug("[DELETE] /users/{userId} : "+userId);
        userService.delete(userId);
        return new ResponseEntity<>(new ResponseDto("유저 정보 삭제 성공", null), HttpStatus.OK);
    }

}
