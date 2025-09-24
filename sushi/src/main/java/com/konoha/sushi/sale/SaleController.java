package com.konoha.sushi.sale;

import com.konoha.sushi.sale.services.abstraction.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    private ISaleService saleService;

    @GetMapping("/search/{folio}")
    public ResponseEntity<SaleDto> findByFolio(@PathVariable String folio) {
        SaleDto sale = saleService.getByFolio(folio);
        return ResponseEntity.ok(sale);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDto> getById(@PathVariable Long id) {
        SaleDto sale = saleService.getById(id);
        return ResponseEntity.ok(sale);
    }

    @GetMapping
    public ResponseEntity<List<SaleDto>> getAll(){
        List<SaleDto> sales = saleService.getAll();
        return ResponseEntity.ok(sales);
    }

    @PostMapping
    public ResponseEntity<SaleDto> add(@RequestBody SaleDto saleDto){
        SaleDto sale = saleService.add(saleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(sale);
    }

    @PutMapping("{id}")
    public ResponseEntity<SaleDto> update(@PathVariable Long id, @RequestBody SaleDto saleDto){
        SaleDto sale = saleService.update(id, saleDto);
        return ResponseEntity.ok(sale);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletById(@PathVariable Long id){
        saleService.deletById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
