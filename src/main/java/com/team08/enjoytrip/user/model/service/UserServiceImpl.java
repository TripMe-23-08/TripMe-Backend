package com.team08.enjoytrip.user.model.service;

import com.team08.enjoytrip.user.exception.UserAlreadyExistException;
import com.team08.enjoytrip.user.exception.UserNotFoundException;
import com.team08.enjoytrip.user.model.dto.UserDto;
import com.team08.enjoytrip.user.model.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signup(UserDto userDto) throws UserAlreadyExistException {
        if (checkIfExist(userDto)) {
            throw new UserAlreadyExistException(userDto.getName() + "로 이미 가입되어있습니다.");
        }
        userRepository.save(userDto);
    }

    private boolean checkIfExist(UserDto userDto) {
        UserDto user = userRepository.findByEmail(userDto.getEmail());
        if (user == null) {
            return false;
        }
        return true;
    }

    @Override
    public UserDto login(String email, String password) throws UserNotFoundException {
        UserDto userDto = userRepository.findByEmail(email);
        if (BCrypt.checkpw(password, userDto.getPassword())) {
            return userDto;
        }
        throw new UserNotFoundException("유저를 찾을 수 없습니다.");
    }

    @Override
    public void logout() {

    }
}
