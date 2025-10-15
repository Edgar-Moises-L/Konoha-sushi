package com.konoha.sushi.product.application;

import com.konoha.sushi.exception.domain.ResourceNotFoundException;
import com.konoha.sushi.product.domain.Category;
import com.konoha.sushi.product.domain.Product;
import com.konoha.sushi.product.domain.ProductRepository;
import com.konoha.sushi.product.domain.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        if (productRepository.existsByName(product.getName())) {
            throw new IllegalArgumentException("The name of product is already taken");
        }
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product updateProduct) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not faund"));
        if (productRepository.existByNameAndIdNot(product.getName(), id)) {
            throw new com.konoha.sushi.exception.domain.IllegalArgumentException("The name of product is already taken");
        }
        product.setCategory(updateProduct.getCategory());
        product.setName(updateProduct.getName());
        product.setDescription(updateProduct.getDescription());
        product.setPrice(updateProduct.getPrice());
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCategory(String category) {
        Category cat = Category.valueOf(category.toUpperCase());
        return productRepository.findByCategory(cat);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
