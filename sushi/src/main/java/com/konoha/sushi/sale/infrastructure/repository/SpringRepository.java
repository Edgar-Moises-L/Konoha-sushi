package com.konoha.sushi.sale.infrastructure.repository;

import com.konoha.sushi.sale.infrastructure.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringRepository extends JpaRepository<SaleEntity, Long > {

}
