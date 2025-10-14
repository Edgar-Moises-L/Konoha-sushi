package com.konoha.sushi.user.infrastructure;

import com.konoha.sushi.user.domain.UserService;
import com.konoha.sushi.user.domain.User;
import com.konoha.sushi.user.infrastructure.dto.UserDTO;
import com.konoha.sushi.user.infrastructure.mapper.UserMap;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final UserMap userMap;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        UserDTO userDTO = userMap.userToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> usersDTO = userService.findAll().stream().map(userMap::userToUserDTO).toList();
        return ResponseEntity.ok(usersDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@Valid  @PathVariable Long id, @RequestBody UserDTO userDTO) {
        User user = userMap.userDTOToUser(userDTO);
        User updated = userService.update(id, user);
        UserDTO updateDTO = userMap.userToUserDTO(updated);
        return ResponseEntity.ok(updateDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


