package com.konoha.sushi.user.domain;

import java.util.List;

public interface UserService {
    User update(Long id, User user);

    List<User> findAll();

    User findById(Long id);

    void delete(Long id);
}

