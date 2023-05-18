package com.team08.enjoytrip.auth.model.repository;

import com.team08.enjoytrip.auth.model.dto.JwtDto;
import com.team08.enjoytrip.user.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthRepository {
    UserDto findByEmail(String email);
    void save(JwtDto jwtDto); // id값, refreshToken
    void delete(int userId);

    String findById(int userId);
}
