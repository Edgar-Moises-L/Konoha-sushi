package com.konoha.sushi.user.domain;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User userEntity);

    Optional<User> findById(Long id);

    List<User> findAll();

    Optional<User> findByUserName(String userName);

    Boolean existsByUserName(String userName);

    void deleteById(Long id);
}
