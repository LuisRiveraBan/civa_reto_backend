package com.example.civaRectoTecnico.repositories;

import com.example.civaRectoTecnico.models.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {


	@Query("SELECT u FROM UsuarioEntity u JOIN FETCH u.rol WHERE u.username = :username")
	public Optional<UsuarioEntity> findByUsernameRol(@Param("username") String username);

}
