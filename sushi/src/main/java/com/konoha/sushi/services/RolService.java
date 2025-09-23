package com.konoha.sushi.services;


import com.konoha.sushi.dto.RoleDto;
import com.konoha.sushi.entity.ERole;
import com.konoha.sushi.entity.PermissionEntity;
import com.konoha.sushi.entity.RoleEntity;
import com.konoha.sushi.exception.ResourceNotFoundException;
import com.konoha.sushi.mapper.PermissionMap;
import com.konoha.sushi.mapper.RoleMap;
import com.konoha.sushi.repository.PermissionRepository;
import com.konoha.sushi.repository.RoleRepository;
import com.konoha.sushi.services.abstraction.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RolService implements IRolService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMap roleMap;
    @Autowired
    private PermissionMap permissionMap;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public RoleDto add(RoleDto roleDto) {
        RoleEntity role = roleMap.toEntity(roleDto);
        role.setPermission(validatePermissions(role.getPermission()));
        RoleEntity roleNew = roleRepository.save(role);
        return roleMap.toDto(roleNew);
    }

    @Override
    public RoleDto update(Long id, RoleDto roleDto) {
        RoleEntity roleSaved = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol con el ID " + id + " no encontrado"));

        roleSaved.setRoleEnum(ERole.valueOf(roleDto.getName()));

        roleSaved.setPermission(validatePermissions(
                roleDto.getPermission().stream()
                        .map(permissionMap::toEntity)
                        .collect(Collectors.toSet())
        ));
        roleSaved.setPermission(validatePermissions(roleSaved.getPermission()));

        RoleEntity roleUpdate = roleRepository.save(roleSaved);
        return roleMap.toDto(roleUpdate);
    }


    @Override
    public List<RoleDto> getAll() {
        return roleRepository.findAll().stream().map(roleMap::toDto).collect(Collectors.toList());
    }

    @Override
    public RoleDto getById(Long id) {
        RoleEntity role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rol con el ID " + id + " no encontrado"));
        return roleMap.toDto(role);
    }

    @Override
    public void deleteById(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Rol con el ID " + id + " no encontrado");
        }
        roleRepository.deleteById(id);
    }

    private Set<PermissionEntity> validatePermissions(Set<PermissionEntity> permission) {
        Set<PermissionEntity> permissionValid = permission
                .stream()
                .map(permiccion -> {
                    return permissionRepository.findByName(permiccion.getName())
                            .orElseGet(() -> {
                                return permissionRepository.save(permiccion);
                            });
                })
                .collect(Collectors.toSet());
        return permissionValid;
    }
}
