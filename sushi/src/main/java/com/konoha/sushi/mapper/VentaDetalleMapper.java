package com.konoha.sushi.mapper;

import com.konoha.sushi.dto.VentaDetalleDto;
import com.konoha.sushi.entity.Venta;
import com.konoha.sushi.entity.VentaDetalle;
import org.springframework.stereotype.Component;

@Component
public class VentaDetalleMapper {

    public VentaDetalleDto toDto(VentaDetalle detalle) {
        VentaDetalleDto dto = new VentaDetalleDto();
        dto.setId(detalle.getId());
        dto.setNombreArticulo(detalle.getNombreArticulo());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecio(detalle.getPrecio());

        if (detalle.getVenta() != null) {
            dto.setFacturaId(detalle.getVenta().getId());
        }

        return dto;
    }

    public VentaDetalle toEntity(VentaDetalleDto dto, Venta venta) {
        VentaDetalle detalle = new VentaDetalle();
        detalle.setId(dto.getId());
        detalle.setNombreArticulo(dto.getNombreArticulo());
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecio(dto.getPrecio());

        detalle.setVenta(venta);

        return detalle;
    }
}




