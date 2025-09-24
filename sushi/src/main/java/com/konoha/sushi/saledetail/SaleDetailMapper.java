package com.konoha.sushi.saledetail;

import com.konoha.sushi.sale.Sale;
import org.springframework.stereotype.Component;

@Component
public class SaleDetailMapper {

    public SaleDetailDto toDto(SaleDetail detalle) {
        SaleDetailDto dto = new SaleDetailDto();
        dto.setId(detalle.getId());
        dto.setNombreArticulo(detalle.getNombreArticulo());
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecio(detalle.getPrecio());

        if (detalle.getVenta() != null) {
            dto.setFacturaId(detalle.getVenta().getId());
        }

        return dto;
    }

    public SaleDetail toEntity(SaleDetailDto dto, Sale venta) {
        SaleDetail detalle = new SaleDetail();
        detalle.setId(dto.getId());
        detalle.setNombreArticulo(dto.getNombreArticulo());
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecio(dto.getPrecio());

        detalle.setVenta(venta);

        return detalle;
    }
}




