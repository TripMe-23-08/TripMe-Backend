package com.team08.enjoytrip.user.model.repository;

import com.team08.enjoytrip.user.exception.UserAlreadyExistException;
import com.team08.enjoytrip.user.model.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("UserRepository : CRUD")
class UserRepositoryTest {
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Check UserRepository")
    public void checkUserRepository() {
        assertThat(userRepository).isNotNull();
    }

    @Test
    @DisplayName("[Fail Test] Add User : Duplicate User by Id")
    @Transactional
    public void addUser() {
        // before
        UserDto userDto = UserDto.builder()
                .id(2)
                .email("b@gmail.com")
                .password("b")
                .name("b")
                .nickName("닉네임b")
                .build();
        userRepository.save(userDto);

        // when // then
        assertThrows(DuplicateKeyException.class, () -> userRepository.save(userDto));
    }

    @Test
    @DisplayName("Update User")
    @Transactional
    public void updateUser() {
        // before
        UserDto userDto = UserDto.builder()
                .id(2)
                .email("b@gmail.com")
                .password("b")
                .name("b")
                .nickName("닉네임b")
                .build();
        userRepository.save(userDto);

        // when
        UserDto savedUser = userRepository.findByEmail(userDto.getEmail());
        savedUser.setNickName("saved B");
        // userRepository.update(savedUser);

        UserDto updatedUser = userRepository.findByEmail(userDto.getEmail());

        // then
        assertThat(updatedUser).isEqualTo(savedUser);
    }

    @Test
    @DisplayName("Delete User")
    @Transactional
    public void deleteUser() {
        // before
        UserDto userDto = UserDto.builder()
                .id(44)
                .email("test@gmail.com")
                .password("test")
                .name("test")
                .build();
        userRepository.save(userDto);

        // when
        UserDto savedUser = userRepository.findByEmail(userDto.getEmail());
        assertThat(savedUser).isNotNull();

        userRepository.delete(savedUser.getId());
        //then
        UserDto deleted = userRepository.findById(userDto.getId());
        assertThat(deleted).isNull();

    }
}