package com.konoha.sushi.dto;

import com.konoha.sushi.entity.Venta;
import lombok.Data;

@Data
public class VentaDetalleDto {
    private Long id;
    private String nombreArticulo;
    private Integer cantidad;
    private Double precio;
    private Long facturaId;
}
