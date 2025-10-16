package com.konoha.sushi.sale.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private Long id;
    private Data creationdate;
    private String nombre;
    private String direccion;

    private Double total;
}
