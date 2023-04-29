package com.team08.enjoytrip.user.model.service;

import com.team08.enjoytrip.user.exception.UserNotFoundException;
import com.team08.enjoytrip.user.model.dto.UserDto;
import com.team08.enjoytrip.user.model.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signup() {

    }

    @Override
    public UserDto login(String email, String password) throws UserNotFoundException {
        UserDto userDto = userRepository.findByEmail(email);
        if(BCrypt.checkpw(password, userDto.getPassword())){
            return userDto;
        }
        throw new UserNotFoundException("유저를 찾을 수 없습니다.");
    }

    @Override
    public void logout() {

    }
}
