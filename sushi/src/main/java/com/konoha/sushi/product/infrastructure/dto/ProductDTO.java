package com.konoha.sushi.product.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;

    @NotNull(message = "The category is mandatory")
    @NotBlank(message = "The category is mandatory")
    private String Category;

    @NotNull(message = "The name is mandatory")
    @NotBlank(message = "The name is mandatory")
    private String name;

    @NotNull(message = "The description is mandatory")
    @NotBlank(message = "The description is mandatory")
    private String description;

    @NotNull(message = "The price is mandatory")
    @Positive(message = "the price must be greater than 0")
    private Double price;
}
