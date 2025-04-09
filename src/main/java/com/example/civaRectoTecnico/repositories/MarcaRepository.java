package com.example.civaRectoTecnico.repositories;

import com.example.civaRectoTecnico.models.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaEntity, Integer> {
}
