package com.example.civaRectoTecnico.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BusDto {

    private Integer id;

    private int numeroBus;

    private String placa;

    private LocalDateTime fechaCreacion;

    private String Caracteristicas;

    private String activo;

    private int idMarca;

    private String marca;

	public BusDto(Integer id, int numeroBus, String placa, LocalDateTime fechaCreacion, String caracteristicas, String activo) {
		super();
		this.id = id;
		this.numeroBus = numeroBus;
		this.placa = placa;
		this.fechaCreacion = fechaCreacion;
		Caracteristicas = caracteristicas;
		this.activo = activo;
	}
    
    
}
