package com.konoha.sushi.user.domain;



import java.util.List;

public interface IUserService {
    User update(User user);

    List<User> findAll();

    User findById(Long id);

    void delete(Long id);
}

