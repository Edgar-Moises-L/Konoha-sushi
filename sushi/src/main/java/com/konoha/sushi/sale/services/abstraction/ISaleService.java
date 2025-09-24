package com.konoha.sushi.sale.services.abstraction;

import com.konoha.sushi.sale.SaleDto;

import java.util.List;

public interface ISaleService {
    SaleDto getByFolio(String folio);
    SaleDto getById(Long id);
    List<SaleDto> getAll();
    SaleDto add(SaleDto saleDto);
    SaleDto update(Long id, SaleDto saleDto);
    void deletById(Long id);
}
