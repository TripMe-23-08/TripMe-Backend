package com.team08.enjoytrip.user.model.service;

import com.team08.enjoytrip.user.exception.UserAlreadyExistException;
import com.team08.enjoytrip.user.exception.UserNotFoundException;
import com.team08.enjoytrip.user.model.dto.UserDto;

public interface UserService {
    void signup(UserDto userDto) throws UserAlreadyExistException; // 회원가입

    UserDto login(String email, String password) throws UserNotFoundException; // 로그인

    void logout(); //로그아웃

    UserDto get(int userId) throws UserNotFoundException;

    void update(UserDto userDto);

    void delete(int userId);
}
