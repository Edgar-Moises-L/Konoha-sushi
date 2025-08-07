package com.konoha.sushi.mapper;

import com.konoha.sushi.dto.VentaDetalleDto;
import com.konoha.sushi.dto.VentaDto;
import com.konoha.sushi.entity.Venta;
import com.konoha.sushi.entity.VentaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VentaMapper {

   @Autowired
   private  VentaDetalleMapper detalleMapper;

    public VentaDto toDto(Venta venta) {
        VentaDto dto = new VentaDto();
        dto.setId(venta.getId());
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());

        if (venta.getDetalle() != null) {
            List<VentaDetalleDto> detalleDtos = venta.getDetalle()
                    .stream()
                    .map(detalleMapper::toDto)
                    .collect(Collectors.toList());

            dto.setDetalle(detalleDtos);
        }

        return dto;
    }

    public Venta toEntity(VentaDto dto) {
        Venta venta = new Venta();
        venta.setId(dto.getId());
        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());

        if (dto.getDetalle() != null) {
            List<VentaDetalle> detalles = dto.getDetalle()
                    .stream()
                    .map(dDto -> detalleMapper.toEntity(dDto, venta))
                    .collect(Collectors.toList());

            venta.setDetalle(detalles);
        }

        return venta;
    }
}



