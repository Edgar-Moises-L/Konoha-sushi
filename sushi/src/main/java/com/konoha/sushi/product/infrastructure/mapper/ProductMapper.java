package com.konoha.sushi.product.infrastructure.mapper;

import com.konoha.sushi.product.domain.Category;
import com.konoha.sushi.product.domain.Product;
import com.konoha.sushi.product.infrastructure.dto.ProductDTO;
import com.konoha.sushi.product.infrastructure.entiry.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product productEntityToProduct(ProductEntity productEntity) {
        if (productEntity == null) return null;

        Product product = new Product();
        product.setId(productEntity.getId());
        product.setCategory(productEntity.getCategory());
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setPrice(productEntity.getPrice());
        return product;
    }

    public ProductEntity productToProductEntity(Product product) {
        if (product == null) return null;

        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setCategory(product.getCategory());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        return entity;
    }

    public ProductDTO productToProductDTO(Product product) {
        if (product == null) return null;

        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setCategory(product.getCategory().name());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }

    public Product productDTOToProduct(ProductDTO dto) {
        if (dto == null) return null;
        Product product = new Product();
        product.setId(dto.getId());
        product.setCategory(Category.valueOf(dto.getCategory()));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }
}
