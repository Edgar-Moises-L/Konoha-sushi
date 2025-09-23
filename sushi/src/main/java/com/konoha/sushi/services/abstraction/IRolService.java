package com.konoha.sushi.services.abstraction;



import com.konoha.sushi.dto.RoleDto;

import java.util.List;

public interface IRolService {
    RoleDto add(RoleDto rol);
    RoleDto update(Long id, RoleDto rol);
    List<RoleDto> getAll();
    RoleDto getById(Long id);
    void deleteById(Long id);
}
