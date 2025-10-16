package com.konoha.sushi.sale.infrastructure.repository;

import com.konoha.sushi.sale.domain.Sale;
import com.konoha.sushi.sale.domain.SaleRepository;
import com.konoha.sushi.sale.infrastructure.mapper.SaleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class MySqlRepository implements SaleRepository {
    private final SpringRepository springRepository;
    private final SaleMapper saleMapper;

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
