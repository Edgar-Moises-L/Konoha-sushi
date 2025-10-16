package com.konoha.sushi.sale.infrastructure;

import com.konoha.sushi.sale.infrastructure.dto.SaleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SaleController {
    ResponseEntity<SaleDTO> save(SaleDTO sale);
    ResponseEntity<SaleDTO> update(Long id, SaleDTO sale);
    ResponseEntity<List<SaleDTO>> findAll();
    ResponseEntity<SaleDTO> findById(Long id);
}
