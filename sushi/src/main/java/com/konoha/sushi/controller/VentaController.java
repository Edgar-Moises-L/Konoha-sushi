package com.konoha.sushi.controller;

import com.konoha.sushi.dto.VentaDto;
import com.konoha.sushi.services.abstraction.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
    @Autowired
    private IVentaService ventaService;

    @GetMapping("/buscar/{folio}")
    public ResponseEntity<VentaDto> findByFolio(@PathVariable String folio) {
        VentaDto venta = ventaService.getByFolio(folio);
        return ResponseEntity.ok(venta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaDto> getById(@PathVariable Long id) {
        VentaDto venta = ventaService.getById(id);
        return ResponseEntity.ok(venta);
    }

    @GetMapping
    public ResponseEntity<List<VentaDto>> getAll(){
        List<VentaDto> ventas = ventaService.getAll();
        return ResponseEntity.ok(ventas);
    }

    @PostMapping
    public ResponseEntity<VentaDto> add(@RequestBody VentaDto ventaDto){
        VentaDto venta = ventaService.add(ventaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(venta);
    }

    @PutMapping("{id}")
    public ResponseEntity<VentaDto> update(@PathVariable Long id, @RequestBody VentaDto vetaDto){
        VentaDto venta = ventaService.update(id, vetaDto);
        return ResponseEntity.ok(venta);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletById(@PathVariable Long id){
        ventaService.deletById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
