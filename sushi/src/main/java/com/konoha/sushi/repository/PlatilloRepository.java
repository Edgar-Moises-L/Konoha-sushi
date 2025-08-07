package com.konoha.sushi.repository;

import com.konoha.sushi.entity.Platillo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatilloRepository extends JpaRepository<Platillo,Long> {
}
