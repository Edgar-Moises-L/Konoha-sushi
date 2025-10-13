package com.konoha.sushi.product.infrastructure.repository;

import com.konoha.sushi.product.domain.ProductRepository;
import com.konoha.sushi.product.infrastructure.entiry.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringProductRepository extends JpaRepository<ProductEntity, Long> {
    Boolean existsByName(String name);

    Boolean existsByNameAndIdNot(String name, Long id);
}
