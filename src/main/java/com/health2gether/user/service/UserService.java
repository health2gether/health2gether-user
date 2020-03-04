package com.health2gether.user.service;

import com.health2gether.user.PasswordHelper;
import com.health2gether.user.dto.UserRequest;
import com.health2gether.user.dto.UserResponse;
import com.health2gether.user.entity.UserEntity;
import com.health2gether.user.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 20/10/2019 22:46
 */
@Service
public class UserService {

    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse save(final UserRequest userRequest) {
        final UserEntity userEntity = userRepository.save(convertToUserEntity(userRequest));
        return convertToUserResponse(userEntity);
    }

    private UserEntity convertToUserEntity(final UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userRequest, userEntity, "password", "birthday");
        userEntity.setPassword(PasswordHelper.hashPassword(userRequest.getPassword()));
        userEntity.setBirthday(LocalDate.parse(userRequest.getBirthday(), PATTERN));
        return userEntity;
    }

    private UserResponse convertToUserResponse(final UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userEntity, userResponse);
        return userResponse;
    }

    public UserResponse findUserByEmailAndPassword(final String email, final String password) {
        final Optional<UserEntity> userResult = userRepository.findByEmail(email);
        if(userResult.isPresent() && PasswordHelper.checkPassword(password, userResult.get().getPassword())) {
            return convertToUserResponse(userResult.get());
        }
        return null;
    }

    public Optional<UserEntity> findById(Long userId) {
        return userRepository.findById(userId);
    }

    public void save(final UserEntity userEntity) {
        userRepository.save(userEntity);
    }

}
