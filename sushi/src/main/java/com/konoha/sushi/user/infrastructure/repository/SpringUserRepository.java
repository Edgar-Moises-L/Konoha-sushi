package com.konoha.sushi.user.infrastructure.repository;

import com.konoha.sushi.user.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringUserRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);

    Boolean existsByUserNameAndIdNot(String userName, Long id);

    Boolean existsByEmailAndIdNot(String email, Long id);

    Optional<UserEntity> findByUserName(String userName);
}
