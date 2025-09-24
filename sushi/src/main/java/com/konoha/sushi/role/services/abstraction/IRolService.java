package com.konoha.sushi.role.services.abstraction;



import com.konoha.sushi.role.RoleDto;

import java.util.List;

public interface IRolService {
    RoleDto add(RoleDto rol);
    RoleDto update(Long id, RoleDto rol);
    List<RoleDto> getAll();
    RoleDto getById(Long id);
    void deleteById(Long id);
}
