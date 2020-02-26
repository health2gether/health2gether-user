package com.health2gether.user.service;

import com.health2gether.user.converter.UserConverter;
import com.health2gether.user.dto.UserResponse;
import com.health2gether.user.entity.UserEntity;
import com.health2gether.user.dto.UserRequest;
import com.health2gether.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public UserResponse save(final UserRequest userRequest) {
        UserEntity userEntity = userRepository.save(userConverter.toUserEntity(userRequest));
        final UserResponse userResponse = userConverter.toUserResponse(userEntity);
        return userResponse;
    }

    public UserResponse findUserByEmailAndPassword(final String email, final String password) {
        final Optional<UserEntity> userResult = userRepository.findByEmailAndPassword(email, password);
        if(userResult.isPresent()) {
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
