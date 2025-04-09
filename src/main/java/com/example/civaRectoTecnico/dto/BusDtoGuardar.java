package com.example.civaRectoTecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BusDtoGuardar {
	
    private int numeroBus;

    private String placa;

    private String Caracteristicas;

    private String activo;

    private int idMarca;
    
}
