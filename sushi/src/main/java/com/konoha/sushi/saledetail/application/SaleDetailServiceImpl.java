package com.konoha.sushi.saledetail.application;

import com.konoha.sushi.saledetail.domain.SaleDetail;
import com.konoha.sushi.saledetail.domain.SaleDetailRepository;
import com.konoha.sushi.saledetail.domain.SaleDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleDetailServiceImpl implements SaleDetailService {
private final SaleDetailRepository saleDetailRepository;

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
