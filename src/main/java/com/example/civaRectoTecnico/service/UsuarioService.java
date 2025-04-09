package com.example.civaRectoTecnico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.civaRectoTecnico.models.UsuarioEntity;
import com.example.civaRectoTecnico.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public <S extends UsuarioEntity> S save(S entity) {
		return repository.save(entity);
	}
	

}
