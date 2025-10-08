package com.konoha.sushi.product.infrastructure.entiry;

import com.konoha.sushi.product.domain.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String name;

    @NotBlank
    @Size(max = 200)
    private String description;

    @NotNull
    @Positive
    private Double price;

}
