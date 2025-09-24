package com.konoha.sushi.saledetail.services;

import com.konoha.sushi.saledetail.SaleDetailDto;
import com.konoha.sushi.saledetail.services.abstraction.ISaleDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleDetailService implements ISaleDetailService {
    @Override
    public SaleDetailDto getById(Long id) {
        return null;
    }

    @Override
    public List<SaleDetailDto> getAll() {
        return List.of();
    }

    @Override
    public SaleDetailDto add(SaleDetailDto ventaDetalleDto) {
        return null;
    }

    @Override
    public SaleDetailDto update(Long id, SaleDetailDto ventaDetalleDto) {
        return null;
    }

    @Override
    public void deletById(Long id) {

    }
}
