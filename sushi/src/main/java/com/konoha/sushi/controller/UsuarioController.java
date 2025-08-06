package com.konoha.sushi.controller;

import com.konoha.sushi.dto.UsuarioDto;
import com.konoha.sushi.services.abstraction.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService  usuarioService;

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<Boolean> existByNombre(@PathVariable String nombre){
        boolean request = usuarioService.existsByNombre(nombre);
        return ResponseEntity.ok(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getById(@PathVariable Long id){
        UsuarioDto usuario = usuarioService.getById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAll(){
        List<UsuarioDto> usuarios = usuarioService.getAll();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> add(@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuario = usuarioService.add(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> update(@PathVariable Long id, @RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuario = usuarioService.update(id, usuarioDto);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleted(@PathVariable Long id){
        usuarioService.deletById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

