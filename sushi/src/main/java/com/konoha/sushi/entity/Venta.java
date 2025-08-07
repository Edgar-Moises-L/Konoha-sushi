package com.konoha.sushi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "venta")
@Data
public class Venta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String folio;
    private LocalDateTime fecha;
    private Double total;

    @OneToMany(mappedBy = "detalle",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<VentaDetalle> detalle;

}
