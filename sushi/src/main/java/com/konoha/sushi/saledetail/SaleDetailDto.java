package com.konoha.sushi.saledetail;

import lombok.Data;

@Data
public class SaleDetailDto {
    private Long id;
    private String nombreArticulo;
    private Integer cantidad;
    private Double precio;
    private Long facturaId;
}
