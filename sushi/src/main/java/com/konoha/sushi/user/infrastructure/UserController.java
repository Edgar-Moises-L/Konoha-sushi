package com.konoha.sushi.user.infrastructure;

import com.konoha.sushi.user.infrastructure.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    ResponseEntity<UserDTO> findById(Long id);

    ResponseEntity<List<UserDTO>> findAll();

    ResponseEntity<UserDTO> update(Long id, UserDTO userDTO);

    ResponseEntity<Void> delete(Long id);
}
