package com.konoha.sushi.saledetail.infrastructure.repository;

import com.konoha.sushi.saledetail.domain.SaleDetailRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringRepository extends JpaRepository<SaleDetailRepository,Long> {
}
