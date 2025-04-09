package com.example.civaRectoTecnico.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.civaRectoTecnico.models.BusEntity;
import com.example.civaRectoTecnico.repositories.BusRepository;

@Service
public class BusService {

    @Autowired
    private BusRepository repository;

    public Page<BusEntity> findAll(Pageable pageable) {
        return repository.findAllWithBrands(pageable);
    }
    
	public Optional<BusEntity> findById(Integer integer) {
        return repository.findById(integer);
    }

    public <S extends BusEntity> S save(S entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer integer) {
        repository.deleteById(integer);
    }
}
