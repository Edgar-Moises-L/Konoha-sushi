package com.konoha.sushi.sale;

import com.konoha.sushi.saledetail.SaleDetailDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SaleDto {
    private Long id;
    private String folio;
    private LocalDateTime fecha;
    private Double total;
    private List<SaleDetailDto> detalle;
}
