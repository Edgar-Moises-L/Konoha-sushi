package com.konoha.sushi.saledetail;

import com.konoha.sushi.sale.Sale;
import org.springframework.stereotype.Component;

@Component
public class SaleDetailMapper {

    public SaleDetailDto toDto(SaleDetail detail) {
        SaleDetailDto dto = new SaleDetailDto();
        dto.setId(detail.getId());
        dto.setProductName(detail.getProductName());
        dto.setQuantity(detail.getQuantity());
        dto.setPrice(detail.getPrice());

        if (detail.getSale() != null) {
            dto.setSaleId(detail.getSale().getId());
        }

        return dto;
    }

    public SaleDetail toEntity(SaleDetailDto dto, Sale sale) {
        SaleDetail detail = new SaleDetail();
        detail.setId(dto.getId());
        detail.setProductName(dto.getProductName());
        detail.setQuantity(dto.getQuantity());
        detail.setPrice(dto.getPrice());

        detail.setSale(sale);

        return detail;
    }
}




