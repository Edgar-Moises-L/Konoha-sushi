package com.konoha.sushi.product.infrastructure.repository;

import com.konoha.sushi.product.domain.Product;
import com.konoha.sushi.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class MySqlRepository implements ProductRepository {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public Boolean existsByName(String name) {
        return null;
    }

    @Override
    public Boolean existByNameAndIdNot(String name, Long id) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
