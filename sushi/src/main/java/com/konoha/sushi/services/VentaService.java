package com.konoha.sushi.services;

import com.konoha.sushi.dto.VentaDto;
import com.konoha.sushi.exception.ResourceNotFoundException;
import com.konoha.sushi.repository.VentaRepositiry;
import com.konoha.sushi.services.abstraction.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VentaService implements IVentaService {
    @Autowired
    private VentaRepositiry ventaRepositiry;
    @Override
    public VentaDto getById(Long id) {
        return null;
    }

    @Override
    public List<VentaDto> getAll() {
        return List.of();
    }

    @Override
    public VentaDto add(VentaDto ventaDto) {
        return null;
    }

    @Override
    public VentaDto update(Long id, VentaDto ventaDto) {
        return null;
    }

    @Override
    public void deletById(Long id) {
        if(!ventaRepositiry.existsById(id)){
            throw new ResourceNotFoundException("Venta con ID " + id + " no encontrado");
        }
        ventaRepositiry.deleteById(id);
    }
}
