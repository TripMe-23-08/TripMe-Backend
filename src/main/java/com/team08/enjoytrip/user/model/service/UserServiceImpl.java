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
            throw new UserAlreadyExistException("[" + userDto.getEmail() + "] 로 이미 가입되어있습니다.");
        }
        userDto.setPassword(BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt()));
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
    public UserDto get(int userId) throws UserNotFoundException {
        UserDto userDto = userRepository.findById(userId);
        if (userDto != null) {
            userDto.setPassword("");
            return userDto;
        }
        throw new UserNotFoundException("유저를 찾을 수 없습니다.");
    }

    @Override
    public void update(UserDto userDto) {
        int userInfoUpdateCnt = userRepository.update(userDto);
        if (userInfoUpdateCnt < 1) {
            throw new UserNotFoundException("유저를 찾을 수 없습니다.");
        }
    }

    @Override
    public void delete(int userId) {
        int delUserCnt = userRepository.delete(userId);
        if (delUserCnt < 1) {
            throw new UserNotFoundException("회원 탈퇴에 실패하셨습니다.");
        }
    }
}
