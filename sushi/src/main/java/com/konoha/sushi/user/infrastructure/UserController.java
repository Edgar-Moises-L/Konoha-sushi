package com.konoha.sushi.user.infrastructure;


import com.konoha.sushi.user.application.UserService;
import com.konoha.sushi.user.domain.User;
import com.konoha.sushi.user.infrastructure.dto.UserDTO;
import com.konoha.sushi.user.domain.IUserService;
import com.konoha.sushi.user.infrastructure.mapper.UserMap;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController implements IUserController {

    private final UserService userService;
    private final UserMap userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id)  {

        User user = userService.findById(id);

        UserDTO userDTO = userMapper.userToUserDTO(user);

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<UserDTO>> findAll() {

        List<UserDTO> userDTOS = userService.findAll().stream().map(userMapper::userToUserDTO).toList();

        return ResponseEntity.ok(userDTOS);
    }

    @PutMapping()
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {

        User user = userMapper.userDTOToUser(userDTO);

        User updated = userService.update(user);

        UserDTO updatedDTO = userMapper.userToUserDTO(updated);

        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
