package com.konoha.sushi.saledetail;

import lombok.Data;

@Data
public class SaleDetailDto {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;
    private Long saleId;
}
