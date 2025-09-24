package com.konoha.sushi.sale.services.abstraction;

import com.konoha.sushi.sale.SaleDto;

import java.util.List;

public interface ISaleService {
    SaleDto getByFolio(String folio);
    SaleDto getById(Long id);
    List<SaleDto> getAll();
    SaleDto add(SaleDto ventaDto);
    SaleDto update(Long id, SaleDto ventaDto);
    void deletById(Long id);
}
