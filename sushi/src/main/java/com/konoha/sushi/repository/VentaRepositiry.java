package com.konoha.sushi.repository;

import com.konoha.sushi.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VentaRepositiry extends JpaRepository<Venta,Long> {
    Optional<Venta> findByFolio(String folio);
}
