package com.konoha.sushi.sale;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepositiry extends JpaRepository<Sale,Long> {
    Optional<Sale> findByFolio(String folio);
}
