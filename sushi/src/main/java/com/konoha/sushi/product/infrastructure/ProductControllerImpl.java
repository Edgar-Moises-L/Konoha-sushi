package com.konoha.sushi.product.infrastructure;

import com.konoha.sushi.product.domain.Product;
import com.konoha.sushi.product.domain.ProductService;
import com.konoha.sushi.product.infrastructure.dto.ProductDTO;
import com.konoha.sushi.product.infrastructure.mapper.ProductMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        Product savedProduct = productService.save(product);
        ProductDTO response = productMapper.productToProductDTO(savedProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(response) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update( @PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        Product update = productService.update(id, product);
        ProductDTO updateDTO = productMapper.productToProductDTO(update);
        return ResponseEntity.ok(updateDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> productDTO = productService.findAll()
                .stream()
                .map(productMapper::productToProductDTO)
                .toList();
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        ProductDTO productDTO = productMapper.productToProductDTO(product);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delet(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
