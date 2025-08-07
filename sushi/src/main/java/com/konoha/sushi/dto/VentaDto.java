package com.konoha.sushi.dto;

import com.konoha.sushi.entity.VentaDetalle;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VentaDto {
    private Long id;
    private LocalDateTime fecha;
    private Double total;
    private List<VentaDetalleDto> detalle;
}
