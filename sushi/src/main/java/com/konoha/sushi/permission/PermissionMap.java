package com.konoha.sushi.permission;


import org.springframework.stereotype.Component;


@Component
public class PermissionMap {
    public PermissionDto toDto(PermissionEntity entity) {
        PermissionDto dto = new PermissionDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public PermissionEntity toEntity(PermissionDto dto) {
        PermissionEntity entity = new PermissionEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    }

}
