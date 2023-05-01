package com.team08.enjoytrip.user.model.repository;

import com.team08.enjoytrip.user.model.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    UserDto findByEmail(String email);

    UserDto findById(int userId);

    int save(UserDto userDto);

    int update(UserDto userDto);

    int delete(int userId);

}
