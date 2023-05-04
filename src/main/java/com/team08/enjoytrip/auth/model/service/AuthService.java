package com.team08.enjoytrip.auth.model.service;

import com.team08.enjoytrip.user.exception.UserNotFoundException;

public interface AuthService {
    String login(String email, String password)throws UserNotFoundException;
    void logout(); //로그아웃
}
