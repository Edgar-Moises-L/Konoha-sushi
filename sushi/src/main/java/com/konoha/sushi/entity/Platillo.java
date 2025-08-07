package com.konoha.sushi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "platillo")
@Data
public class Platillo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;
}
