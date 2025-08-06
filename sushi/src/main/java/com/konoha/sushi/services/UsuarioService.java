package com.konoha.sushi.services;

import com.konoha.sushi.dto.UsuarioDto;
import com.konoha.sushi.entity.Usuario;
import com.konoha.sushi.exception.ResourceNotFoundException;
import com.konoha.sushi.mapper.UsuarioMapper;
import com.konoha.sushi.repository.UsuarioRepository;
import com.konoha.sushi.services.abstraction.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;


    @Override
    public boolean existsByNombre(String nombre) {
        return usuarioRepository.existsByNombre(nombre);
    }

    @Override
    public UsuarioDto getById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado"));
        return usuarioMapper.toDto(usuario);
    }

    @Override
    public List<UsuarioDto> getAll() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDto add(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        Usuario usuarioNuevo = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioNuevo);
    }

    @Override
    public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
        Usuario usuarioGuardado = usuarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado")) ;
        usuarioGuardado.setNombre(usuarioDto.getNombre());
        usuarioGuardado.setRol(usuarioDto.getRol());
        usuarioGuardado.setPassword(usuarioDto.getPassword());
        Usuario usuarioActualizado = usuarioRepository.save(usuarioGuardado);
        return usuarioMapper.toDto(usuarioActualizado);
    }

    @Override
    public void deletById(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new ResourceNotFoundException("Usuario con ID " + id + " no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
