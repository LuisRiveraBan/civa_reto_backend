package com.example.civaRectoTecnico.resControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.civaRectoTecnico.dto.ResponseDto;
import com.example.civaRectoTecnico.service.MarcaService;

@Controller
@RequestMapping("/webapi/marca")
public class MarcaRestController {
	
	@Autowired
	private MarcaService service;
	
	@GetMapping()
	public ResponseEntity<ResponseDto> obtenerMarcas(){
		ResponseDto responseDto = new ResponseDto("Listado con exito", service.findAll(), 200);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDto> buscarMarca(@PathVariable Integer id){
		ResponseDto responseDto = new ResponseDto("Marca encontrada con exito", service.findById(id), 200);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}
	
	
}
