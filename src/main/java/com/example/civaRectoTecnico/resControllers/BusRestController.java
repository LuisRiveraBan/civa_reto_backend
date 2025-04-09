package com.example.civaRectoTecnico.resControllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.civaRectoTecnico.dto.BusDto;
import com.example.civaRectoTecnico.dto.BusDtoGuardar;
import com.example.civaRectoTecnico.dto.ResponseDto;
import com.example.civaRectoTecnico.mappers.BusMapper;
import com.example.civaRectoTecnico.models.BusEntity;
import com.example.civaRectoTecnico.models.MarcaEntity;
import com.example.civaRectoTecnico.service.BusService;
import com.example.civaRectoTecnico.service.MarcaService;

@Controller
@RequestMapping("/webapi/buses")
public class BusRestController {

    @Autowired
    private BusService service;
    
    @Autowired
    private MarcaService marcaService;
                               
    @GetMapping()
    public ResponseEntity<ResponseDto> obtenerBuses(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "25") int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
		ResponseDto responseDto = new ResponseDto("Listado con exito", service.findAll(pageable).map(BusMapper::toDto), 200);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> BuscarBus(@PathVariable Integer id) {
		ResponseDto responseDto = new ResponseDto("Bus encontrada con exito", service.findById(id).stream().map(BusMapper::toDto).toList(), 200);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    
    @PostMapping()
    public ResponseEntity<ResponseDto> registrar(@RequestBody BusDtoGuardar dto){
    	BusEntity params = BusMapper.toEntity(dto);
		ResponseDto responseDto = new ResponseDto("Bus guardado con exito", service.save(params), 200);
		return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> actualizar(@RequestBody BusDto dto, @PathVariable Integer id){
    	Optional<BusEntity> bus = service.findById(id);
    	
    	if(bus.isPresent()) {
    		BusEntity params = bus.get();
    		params.setNumeroBus(dto.getNumeroBus());
    		params.setPlaca(dto.getPlaca());
    		params.setCaracteristicas(dto.getCaracteristicas());
    		params.setActivo(dto.getActivo());
    		Optional<MarcaEntity> marca = marcaService.findById(dto.getIdMarca());
    		
    		if(marca.isPresent()) {
    			params.setMarca(marca.get());
    		}
    		
    		ResponseDto responseDto = new ResponseDto("Bus actualizado con exito", service.save(params) , 200);
    		return new ResponseEntity<>(responseDto, HttpStatus.OK);
    		
    	}
    	
		return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> eliminar(@PathVariable Integer id){
    	service.deleteById(id);
		ResponseDto responseDto = new ResponseDto("Bus eliminado con exito", ":)", 200);
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    
    

    
}
