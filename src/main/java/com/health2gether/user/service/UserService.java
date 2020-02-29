package com.health2gether.user.service;

import com.health2gether.user.PasswordHelper;
import com.health2gether.user.converter.UserConverter;
import com.health2gether.user.dto.UserResponse;
import com.health2gether.user.entity.UserEntity;
import com.health2gether.user.dto.UserRequest;
import com.health2gether.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 20/10/2019 22:46
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private UserConverter userConverter;

    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public UserResponse save(final UserRequest userRequest) {
        UserEntity userEntity = userRepository.save(userConverter.toUserEntity(userRequest));
        final UserResponse userResponse = userConverter.toUserResponse(userEntity);
        return userResponse;
    }

    public UserResponse findUserByEmailAndPassword(final String email, final String password) {
        final Optional<UserEntity> userResult = userRepository.findByEmail(email);
        if(userResult.isPresent() && PasswordHelper.checkPassword(password, userResult.get().getPassword())) {
            return userConverter.toUserResponse(userResult.get());
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
