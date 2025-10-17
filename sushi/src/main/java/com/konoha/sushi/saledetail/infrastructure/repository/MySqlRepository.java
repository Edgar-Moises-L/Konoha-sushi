package com.konoha.sushi.saledetail.infrastructure.repository;

import com.konoha.sushi.sale.infrastructure.mapper.SaleMapper;
import com.konoha.sushi.sale.infrastructure.repository.SpringRepository;
import com.konoha.sushi.saledetail.domain.SaleDetail;
import com.konoha.sushi.saledetail.domain.SaleDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MySqlRepository implements SaleDetailRepository {
    private final SpringRepository springRepository;
    private final SaleMapper saleMapper;

    @Override
    public SaleDetail save(SaleDetail saleDetail) {
        return null;
    }

    @Override
    public SaleDetail update(Long id, SaleDetail saleDetail) {
        return null;
    }

    @Override
    public List<SaleDetail> findAll() {
        return List.of();
    }

    @Override
    public void delet(Long id) {

    }
}
