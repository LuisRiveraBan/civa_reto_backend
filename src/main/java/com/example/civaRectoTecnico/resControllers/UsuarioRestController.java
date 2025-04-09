package com.example.civaRectoTecnico.resControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.civaRectoTecnico.dto.ResponseDto;
import com.example.civaRectoTecnico.dto.UsuarioDto;
import com.example.civaRectoTecnico.models.RolEntity;
import com.example.civaRectoTecnico.models.UsuarioEntity;
import com.example.civaRectoTecnico.service.UsuarioService;

@Controller
@RequestMapping("/webapi/usuario")
public class UsuarioRestController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsuarioService service;
	
	@PostMapping()
	public ResponseEntity<ResponseDto> registrar(@RequestBody UsuarioDto dto){
		UsuarioEntity params = new UsuarioEntity();
		params.setNombre(dto.getNombre());
		params.setApellido(dto.getApellido());
		params.setCorreoElectronico(dto.getCorreoElectronico());
		params.setUsername(dto.getUsername());
		params.setPassword(passwordEncoder.encode(dto.getPassword()));
		RolEntity rolparams = new RolEntity();
		rolparams.setIdRol(dto.getIdRol());
		rolparams.setDescripcion(dto.getDescripcion());
		params.setRol(rolparams);			
    	ResponseDto responseDto = new ResponseDto("Usuario guardado con exito", service.save(params), 200);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
	}

}
