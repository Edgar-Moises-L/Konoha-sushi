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
   private SaleDetailMapper saleDetailMapper;

    public SaleDto toDto(Sale sale) {
        SaleDto dto = new SaleDto();
        dto.setId(sale.getId());
        dto.setFolio(sale.getFolio());
        dto.setDate(sale.getDate());
        dto.setTotal(sale.getTotal());

        if (sale.getDetail() != null) {
            List<SaleDetailDto> detalleDtos = sale.getDetail()
                    .stream()
                    .map(saleDetailMapper::toDto)
                    .collect(Collectors.toList());

            dto.setDetail(detalleDtos);
        }

        return dto;
    }

    public Sale toEntity(SaleDto dto) {
        Sale sale = new Sale();
        sale.setId(dto.getId());
        sale.setFolio(dto.getFolio());
        sale.setDate(dto.getDate());
        sale.setTotal(dto.getTotal());

        if (dto.getDetail() != null) {
            List<SaleDetail> detail = dto.getDetail()
                    .stream()
                    .map(dDto -> saleDetailMapper.toEntity(dDto, sale))
                    .collect(Collectors.toList());

            sale.setDetail(detail);
        }

        return sale;
    }
}



