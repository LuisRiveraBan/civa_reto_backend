package com.example.civaRectoTecnico.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.civaRectoTecnico.models.BusEntity;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Integer> {

    @Query("SELECT B FROM BusEntity B JOIN FETCH B.marca")
    public Page<BusEntity> findAllWithBrands(Pageable pageable);
    
    Page<BusEntity> findAll(Pageable pageable);

}
