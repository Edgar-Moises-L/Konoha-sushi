package com.konoha.sushi.user.services;


import com.konoha.sushi.user.UserDto;
import com.konoha.sushi.user.UserEntity;
import com.konoha.sushi.user.UserMap;
import com.konoha.sushi.user.UserRepository;
import com.konoha.sushi.user.services.abstraction.IUserService;
import com.konoha.sushi.role.ERole;
import com.konoha.sushi.role.RoleEntity;
import com.konoha.sushi.exception.ResourceNotFoundException;
import com.konoha.sushi.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMap userMap;

    @Override
    public UserDto findByUsername(String userName) {
        UserEntity user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con username " + userName + " no encontrado"));
        return userMap.toDto(user);
    }

    @Override
    public UserDto add(UserDto userDto) {
        UserEntity user = userMap.toEntity(userDto);

        Set<RoleEntity> roles = userDto.getRoles().stream()
                .map(roleName -> roleRepository.findByRoleEnum(ERole.valueOf(roleName))
                        .orElseThrow(() -> new ResourceNotFoundException("Rol " + roleName + " no encontrado")))
                .collect(Collectors.toSet());

        user.setRole(roles);

        UserEntity newUser = userRepository.save(user);
        return userMap.toDto(newUser);
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        UserEntity userSaved = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));

        userSaved.setEmail(userDto.getEmail());
        userSaved.setUserName(userDto.getUserName());
        userSaved.setPassword(userDto.getPassword());

        Set<RoleEntity> roles = userDto.getRoles().stream()
                .map(roleName -> roleRepository.findByRoleEnum(ERole.valueOf(roleName))
                        .orElseThrow(() -> new ResourceNotFoundException("Rol " + roleName + " no encontrado")))
                .collect(Collectors.toSet());

        userSaved.setRole(roles);

        UserEntity updatedUser = userRepository.save(userSaved);
        return userMap.toDto(updatedUser);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMap::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
        return userMap.toDto(user);
    }

    @Override
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario con ID " + id + " no encontrado");
        }
        userRepository.deleteById(id);
    }
}
