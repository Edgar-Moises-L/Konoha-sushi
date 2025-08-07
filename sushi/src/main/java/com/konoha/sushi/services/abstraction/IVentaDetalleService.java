package com.konoha.sushi.services.abstraction;

import com.konoha.sushi.dto.VentaDetalleDto;


import java.util.List;

public interface IVentaDetalleService {
    VentaDetalleDto getById(Long id);
    List<VentaDetalleDto> getAll();
    VentaDetalleDto add(VentaDetalleDto ventaDetalleDto);
    VentaDetalleDto update(Long id, VentaDetalleDto ventaDetalleDto);
    void deletById(Long id);
}
