package com.konoha.sushi.sale;

import com.konoha.sushi.saledetail.SaleDetailDto;
import com.konoha.sushi.saledetail.SaleDetailMapper;
import com.konoha.sushi.saledetail.SaleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SaleMapper {

   @Autowired
   private SaleDetailMapper detalleMapper;

    public SaleDto toDto(Sale venta) {
        SaleDto dto = new SaleDto();
        dto.setId(venta.getId());
        dto.setFolio(venta.getFolio());
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());

        if (venta.getDetalle() != null) {
            List<SaleDetailDto> detalleDtos = venta.getDetalle()
                    .stream()
                    .map(detalleMapper::toDto)
                    .collect(Collectors.toList());

            dto.setDetalle(detalleDtos);
        }

        return dto;
    }

    public Sale toEntity(SaleDto dto) {
        Sale venta = new Sale();
        venta.setId(dto.getId());
        venta.setFolio(dto.getFolio());
        venta.setFecha(dto.getFecha());
        venta.setTotal(dto.getTotal());

        if (dto.getDetalle() != null) {
            List<SaleDetail> detalles = dto.getDetalle()
                    .stream()
                    .map(dDto -> detalleMapper.toEntity(dDto, venta))
                    .collect(Collectors.toList());

            venta.setDetalle(detalles);
        }

        return venta;
    }
}



