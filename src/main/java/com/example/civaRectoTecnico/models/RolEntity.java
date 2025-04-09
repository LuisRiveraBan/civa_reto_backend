package com.example.civaRectoTecnico.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(length = 5)
    private String descripcion;

    @OneToMany(mappedBy = "rol")
    private List<UsuarioEntity> usuarios;

	public RolEntity(Integer idRol, String descripcion) {
		super();
		this.idRol = idRol;
		this.descripcion = descripcion;
	}
    
    
}
