package com.konoha.sushi.repository;

import com.konoha.sushi.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepositiry extends JpaRepository<Venta,Long> {
}
