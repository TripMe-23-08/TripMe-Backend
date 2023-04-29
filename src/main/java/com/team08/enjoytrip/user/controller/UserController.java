package com.team08.enjoytrip.user.controller;

import com.team08.enjoytrip.common.dto.ResponseDto;
import com.team08.enjoytrip.user.exception.UserAlreadyExistException;
import com.team08.enjoytrip.user.exception.UserNotFoundException;
import com.team08.enjoytrip.user.model.dto.LoginRequestDto;
import com.team08.enjoytrip.user.model.dto.UserDto;
import com.team08.enjoytrip.user.model.service.UserService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class UserController { // http://localhost:8080/api/v1/
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseDto> signUp(@RequestBody @Valid UserDto userDto) throws UserAlreadyExistException {
        log.debug("[POST] /signup :"+userDto.toString());
        //TODO: Valid UserDto ; email, password not empty & satisfy password generation rules
        userService.signup(userDto);
        return new ResponseEntity<>(new ResponseDto("회원가입에 성공하셨습니다.",null), HttpStatus.CREATED);

    }
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody @Valid LoginRequestDto requestDto) throws UserNotFoundException {
        log.debug("[POST] /login :"+requestDto.toString());

        userService.login(requestDto.getEmail(),requestDto.getPassword());
        return new ResponseEntity<>(new ResponseDto("로그인에 성공하셨습니다.",null), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseDto> logout(HttpSession session){
        session.invalidate();
        //userService.logout();
        return new ResponseEntity<>(new ResponseDto("로그인에 성공하셨습니다.",null), HttpStatus.OK);
    }
}
