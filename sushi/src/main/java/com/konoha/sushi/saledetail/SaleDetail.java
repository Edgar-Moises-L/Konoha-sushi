package com.konoha.sushi.saledetail;

import com.konoha.sushi.sale.Sale;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "venta-detalle")
@Data
public class SaleDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nombreArticulo;
    private Integer cantidad;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "venta_id",nullable = false)
    private Sale venta;

}
