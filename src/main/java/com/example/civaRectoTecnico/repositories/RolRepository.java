package com.example.civaRectoTecnico.repositories;

import com.example.civaRectoTecnico.models.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer> {
}
