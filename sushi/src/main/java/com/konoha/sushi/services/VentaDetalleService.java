package com.konoha.sushi.services;

import com.konoha.sushi.dto.VentaDetalleDto;
import com.konoha.sushi.services.abstraction.IVentaDetalleService;

import java.util.List;

public class VentaDetalleService implements IVentaDetalleService {
    @Override
    public VentaDetalleDto getById(Long id) {
        return null;
    }

    @Override
    public List<VentaDetalleDto> getAll() {
        return List.of();
    }

    @Override
    public VentaDetalleDto add(VentaDetalleDto ventaDetalleDto) {
        return null;
    }

    @Override
    public VentaDetalleDto update(Long id, VentaDetalleDto ventaDetalleDto) {
        return null;
    }

    @Override
    public void deletById(Long id) {

    }
}
