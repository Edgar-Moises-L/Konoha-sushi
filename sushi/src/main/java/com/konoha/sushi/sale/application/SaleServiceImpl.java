package com.konoha.sushi.sale.application;

import com.konoha.sushi.sale.domain.Sale;
import com.konoha.sushi.sale.domain.SaleRepository;
import com.konoha.sushi.sale.domain.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;

    @Override
    public Sale save(Sale sale) {
        return null;
    }

    @Override
    public Sale update(Long id, Sale sale) {
        return null;
    }

    @Override
    public List<Sale> findAll() {
        return List.of();
    }

    @Override
    public Sale findById(Long id) {
        return null;
    }
}
