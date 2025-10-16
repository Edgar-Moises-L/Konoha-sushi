package com.konoha.sushi.sale.infrastructure;

import com.konoha.sushi.sale.domain.SaleService;
import com.konoha.sushi.sale.infrastructure.dto.SaleDTO;
import com.konoha.sushi.sale.infrastructure.mapper.SaleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleControllerImpl implements SaleController{
    private final SaleService saleService;
    private final SaleMapper saleMapper;

    @Override
    public ResponseEntity<SaleDTO> save(SaleDTO sale) {
        return null;
    }

    @Override
    public ResponseEntity<SaleDTO> update(Long id, SaleDTO sale) {
        return null;
    }

    @Override
    public ResponseEntity<List<SaleDTO>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<SaleDTO> findById(Long id) {
        return null;
    }
}
