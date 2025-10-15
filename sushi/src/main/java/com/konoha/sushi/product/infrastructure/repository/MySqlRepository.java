package com.konoha.sushi.product.infrastructure.repository;

import com.konoha.sushi.product.domain.Category;
import com.konoha.sushi.product.domain.Product;
import com.konoha.sushi.product.domain.ProductRepository;

import com.konoha.sushi.product.infrastructure.entiry.ProductEntity;
import com.konoha.sushi.product.infrastructure.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MySqlRepository implements ProductRepository {

    private final SpringProductRepository springProductRepository;
    private final ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        ProductEntity entity = productMapper.productToProductEntity(product);
        ProductEntity saved = springProductRepository.save(entity);
        return productMapper.productEntityToProduct(saved);
    }

    @Override
    public List<Product> findAll() {
        return springProductRepository.findAll()
                .stream()
                .map(productMapper::productEntityToProduct)
                .toList();
    }

    @Override
    public List<Product> findByCategory(Category category) {

        return springProductRepository.findByCategory(category)
                .stream()
                .map(productMapper::productEntityToProduct)
                .toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return springProductRepository.findById(id).map(productMapper::productEntityToProduct);
    }

    @Override
    public Boolean existsByName(String name) {
        return springProductRepository.existsByName(name);
    }

    @Override
    public Boolean existByNameAndIdNot(String name, Long id) {
        return springProductRepository.existsByNameAndIdNot(name, id);
    }

    @Override
    public Boolean existsById(Long id) {
        return springProductRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        springProductRepository.deleteById(id);
    }
}
