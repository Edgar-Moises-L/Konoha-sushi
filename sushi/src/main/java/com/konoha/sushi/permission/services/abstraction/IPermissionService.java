package com.konoha.sushi.permission.services.abstraction;



import com.konoha.sushi.permission.PermissionDto;

import java.util.List;

public interface IPermissionService {
    PermissionDto add(PermissionDto permissionDto);
    PermissionDto update(Long Id, PermissionDto permissionDto);
    PermissionDto getById(Long id);
    PermissionDto getByName(String name);
    List<PermissionDto> getAll();
    void delete(Long id);
}
