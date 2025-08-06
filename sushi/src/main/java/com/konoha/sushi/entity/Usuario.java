package com.konoha.sushi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Id
 private Long id;
 private String nombre;
 private String rol;
 private String password;
}
