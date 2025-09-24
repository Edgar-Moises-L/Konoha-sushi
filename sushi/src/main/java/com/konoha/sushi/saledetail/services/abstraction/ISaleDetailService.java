package com.konoha.sushi.saledetail.services.abstraction;

import com.konoha.sushi.saledetail.SaleDetailDto;


import java.util.List;

public interface ISaleDetailService {
    SaleDetailDto getById(Long id);
    List<SaleDetailDto> getAll();
    SaleDetailDto add(SaleDetailDto ventaDetalleDto);
    SaleDetailDto update(Long id, SaleDetailDto ventaDetalleDto);
    void deletById(Long id);
}
