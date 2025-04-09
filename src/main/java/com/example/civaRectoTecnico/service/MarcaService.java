package com.example.civaRectoTecnico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.civaRectoTecnico.dto.MarcaDto;
import com.example.civaRectoTecnico.models.MarcaEntity;
import com.example.civaRectoTecnico.repositories.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repository;
	
	public List<MarcaDto> findAll() {
		return repository.findAll().stream().map(c -> new MarcaDto(c.getId(), c.getMarca())).toList();
	}

	public Optional<MarcaEntity> findById(Integer id) {
		return repository.findById(id);
	}

}
