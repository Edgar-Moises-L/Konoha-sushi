package com.konoha.sushi.repository;


import com.konoha.sushi.entity.ERole;
import com.konoha.sushi.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByRoleEnum(ERole roleEnum);
}
