package com.konoha.sushi.services.abstraction;



import com.konoha.sushi.dto.UserDto;

import java.util.List;

public interface IUserService {
    UserDto findByUsername(String userName);
    UserDto add(UserDto user);
    UserDto update(Long id, UserDto user);
    List<UserDto> getAll();
    UserDto getById(Long id);
    void deleteById(Long id);
}
