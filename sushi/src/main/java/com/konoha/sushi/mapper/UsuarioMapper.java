package com.konoha.sushi.mapper;

import com.konoha.sushi.dto.UsuarioDto;
import com.konoha.sushi.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioDto toDto(Usuario usuario){
        UsuarioDto dto = new UsuarioDto();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setRol(usuario.getRol());
        dto.setPassword(usuario.getPassword());
        return dto;
    }

    public Usuario toEntity(UsuarioDto dto){
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setRol(dto.getRol());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }
}
