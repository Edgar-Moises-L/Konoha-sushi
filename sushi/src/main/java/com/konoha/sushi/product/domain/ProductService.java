package com.konoha.sushi.product.domain;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    Product update(Long id, Product product);

    List<Product> findAll();

    List<Product> findByCategory(String category);

    Product findById(Long id);

    void delete(Long id);
}
