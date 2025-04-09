package com.example.civaRectoTecnico.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String username;
    
    @Column(length = 20)
    private String nombre;
    
    @Column(length = 20)
    private String apellido;

    @Column(length = 20)
    private String correoElectronico;

    private String password;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private RolEntity rol;

	public UsuarioEntity(Integer id, String username, String nombre, String apellido, String correoElectronico,
			String password) {
		super();
		this.id = id;
		this.username = username;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correoElectronico = correoElectronico;
		this.password = password;
	}
    
    
}
