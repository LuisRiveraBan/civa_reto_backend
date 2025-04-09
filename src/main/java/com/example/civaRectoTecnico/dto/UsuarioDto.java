package com.example.civaRectoTecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

	
    private String username;

    private String nombre;

    private String apellido;

    private String correoElectronico;

    private String password;

    private int idRol;
    
    private String descripcion;
}
