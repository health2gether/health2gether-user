package com.health2gether.user.repository;

import com.health2gether.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 20/10/2019 22:46
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
