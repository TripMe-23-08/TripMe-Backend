package com.team08.enjoytrip.auth.model.service;

import com.team08.enjoytrip.auth.JwtUtil;
import com.team08.enjoytrip.auth.model.repository.AuthRepository;
import com.team08.enjoytrip.user.exception.UserNotFoundException;
import com.team08.enjoytrip.user.model.dto.UserDto;
import com.team08.enjoytrip.user.model.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private JwtUtil jwtUtil;
    private AuthRepository authRepository;

    public AuthServiceImpl(JwtUtil jwtUtil, AuthRepository authRepository) {
        this.jwtUtil = jwtUtil;
        this.authRepository = authRepository;
    }
    @Override
    public String login(String email, String password) {
        UserDto userDto = authRepository.findByEmail(email);
        if (BCrypt.checkpw(password, userDto.getPassword())) {
            return jwtUtil.generateToken(userDto.getNickName(), 1000 * 60 * 60 * 10 );
        }
        throw new UserNotFoundException("유저를 찾을 수 없습니다.");
    }

    @Override
    public void logout() {

    }
}
