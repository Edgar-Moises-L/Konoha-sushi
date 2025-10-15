package com.konoha.sushi.product.infrastructure;

import com.konoha.sushi.product.infrastructure.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {
    ResponseEntity<ProductDTO> save(ProductDTO productDTO);

    ResponseEntity<ProductDTO> update(Long id, ProductDTO productDTO);

    ResponseEntity<List<ProductDTO>> findAll();

    ResponseEntity<List<ProductDTO>> findByCategory(String category);

    ResponseEntity<ProductDTO> findById(Long id);

    ResponseEntity<Void> delet(Long id);
}
