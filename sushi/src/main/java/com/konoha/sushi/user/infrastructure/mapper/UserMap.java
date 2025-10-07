package com.konoha.sushi.user.infrastructure.mapper;

import com.konoha.sushi.auth.infrastructure.RegisterRequest;
import com.konoha.sushi.user.domain.Role;
import com.konoha.sushi.user.domain.User;
import com.konoha.sushi.user.infrastructure.dto.UserDTO;
import com.konoha.sushi.user.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMap {

    public User userEntityToUser(UserEntity userEntity) {
        if (userEntity == null) return null;
        User user = new User();
        user.setId(userEntity.getId());
        user.setUserName(userEntity.getUserName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setRole(userEntity.getRole());
        return user;
    }


    public UserEntity userToUserEntity(User user) {
        if (user == null) return null;
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUserName(user.getUserName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        return userEntity;
    }


    public UserDTO userToUserDTO(User user) {
        if (user == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setRole(user.getRole().name());
        return userDTO;
    }

    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) return null;
        User user = new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setRole(Role.valueOf(userDTO.getRole()));
        return user;
    }

    public User registerRequestToUser(RegisterRequest registerRequest) {
        if (registerRequest == null) return null;
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

}

