package com.konoha.sushi.sale.services;

import com.konoha.sushi.sale.SaleDto;
import com.konoha.sushi.exception.domain.ResourceNotFoundException;
import com.konoha.sushi.sale.SaleRepositiry;
import com.konoha.sushi.sale.services.abstraction.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleService implements ISaleService {
    @Autowired
    private SaleRepositiry saleRepositiry;

    @Override
    public SaleDto getByFolio(String folio) {
        return null;
    }

    @Override
    public SaleDto getById(Long id) {
        return null;
    }

    @Override
    public List<SaleDto> getAll() {
        return List.of();
    }

    @Override
    public SaleDto add(SaleDto saleDto) {
        return null;
    }

    @Override
    public SaleDto update(Long id, SaleDto saleDto) {
        return null;
    }

    @Override
    public void deletById(Long id) {
        if(!saleRepositiry.existsById(id)){
            throw new ResourceNotFoundException("Venta con ID " + id + " no encontrado");
        }
        saleRepositiry.deleteById(id);
    }
}
