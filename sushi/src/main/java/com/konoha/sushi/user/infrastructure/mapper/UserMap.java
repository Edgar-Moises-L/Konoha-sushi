package com.konoha.sushi.user.infrastructure.mapper;


import com.konoha.sushi.role.RoleEntity;
import com.konoha.sushi.user.infrastructure.dto.UserDTO;
import com.konoha.sushi.user.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMap {

    public UserDTO toDto(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setRoles(entityToString(entity.getRole()));

        return dto;
    }


    public UserEntity toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        entity.setEnabled(true);
        entity.setAccountNoExpired(true);
        entity.setAccountNoLocked(true);
        entity.setCredentialNoExpired(true);
        return entity;
    }

    private Set<String> entityToString(Set<RoleEntity> roles) {
        return roles.stream()
                .map(r -> r.getRoleEnum().name())
                .collect(Collectors.toSet());
    }
}

