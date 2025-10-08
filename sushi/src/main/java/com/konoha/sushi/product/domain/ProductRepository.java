package com.konoha.sushi.product.domain;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);

    List<Product> findAll();

    Product findById(Long id);

    Boolean existsByName(String name);

    Boolean existByNameAndIdNot(String name, Long id);

    Boolean existsById(Long id);

    void deleteById(Long id);
}
