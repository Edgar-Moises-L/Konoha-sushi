package com.konoha.sushi.services.abstraction;

import com.konoha.sushi.dto.UsuarioDto;

import java.util.List;

public interface IUsuarioService {
    boolean existsByNombre(String nombre);
    UsuarioDto getById(Long id);
    List<UsuarioDto> getAll();
    UsuarioDto add(UsuarioDto usuarioDto);
    UsuarioDto update(Long id, UsuarioDto usuarioDto);
    void deletById(Long id);

}
