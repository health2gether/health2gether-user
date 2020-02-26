package com.health2gether.user.converter;

import com.health2gether.user.dto.UserResponse;
import com.health2gether.user.dto.UserRequest;
import com.health2gether.user.entity.UserEntity;
import com.health2gether.user.entity.enums.UserStatus;
import org.springframework.stereotype.Component;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 26/10/2019 15:48
 */
@Component
public class UserConverter {

    public UserEntity toUserEntity(final UserRequest userRequest) {
        return UserEntity.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .phone(userRequest.getPhone())
                .status(UserStatus.PENDING)
                .build();
    }

    public UserResponse toUserResponse(final UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .phone(userEntity.getPhone())
                .build();
    }

}
