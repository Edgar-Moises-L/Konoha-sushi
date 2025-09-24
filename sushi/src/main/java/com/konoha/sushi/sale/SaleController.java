package com.konoha.sushi.sale;

import com.konoha.sushi.sale.services.abstraction.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venta")
public class SaleController {
    @Autowired
    private ISaleService ventaService;

    @GetMapping("/buscar/{folio}")
    public ResponseEntity<SaleDto> findByFolio(@PathVariable String folio) {
        SaleDto venta = ventaService.getByFolio(folio);
        return ResponseEntity.ok(venta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> getById(@PathVariable Long id) {
        SaleDto venta = ventaService.getById(id);
        return ResponseEntity.ok(venta);
    }

    @GetMapping
    public ResponseEntity<List<SaleDto>> getAll(){
        List<SaleDto> ventas = ventaService.getAll();
        return ResponseEntity.ok(ventas);
    }

    @PostMapping
    public ResponseEntity<SaleDto> add(@RequestBody SaleDto ventaDto){
        SaleDto venta = ventaService.add(ventaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(venta);
    }

    @PutMapping("{id}")
    public ResponseEntity<SaleDto> update(@PathVariable Long id, @RequestBody SaleDto vetaDto){
        SaleDto venta = ventaService.update(id, vetaDto);
        return ResponseEntity.ok(venta);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletById(@PathVariable Long id){
        ventaService.deletById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
