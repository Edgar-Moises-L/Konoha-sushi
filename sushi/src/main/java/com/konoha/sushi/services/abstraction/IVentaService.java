package com.konoha.sushi.services.abstraction;

import com.konoha.sushi.dto.VentaDto;

import java.util.List;

public interface IVentaService {
    VentaDto getById(Long id);
    List<VentaDto> getAll();
    VentaDto add(VentaDto ventaDto);
    VentaDto update(Long id, VentaDto ventaDto);
    void deletById(Long id);
}
