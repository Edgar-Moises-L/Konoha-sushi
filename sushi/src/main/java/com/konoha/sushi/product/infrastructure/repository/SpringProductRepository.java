package com.konoha.sushi.product.infrastructure.repository;

import com.konoha.sushi.product.domain.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringProductRepository extends JpaRepository<ProductRepository, Long> {
    Boolean existsByName(String name);

    Boolean existsByNameAndIdNot(String name, Long id);
}
