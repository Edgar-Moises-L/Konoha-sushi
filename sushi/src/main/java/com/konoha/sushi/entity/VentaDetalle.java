package com.konoha.sushi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "venta-detalle")
@Data
public class VentaDetalle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nombreArticulo;
    private Integer cantidad;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "venta_id",nullable = false)
    private Venta venta;

}
