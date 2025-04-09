package com.example.civaRectoTecnico.mappers;

import com.example.civaRectoTecnico.dto.BusDto;
import com.example.civaRectoTecnico.dto.BusDtoGuardar;
import com.example.civaRectoTecnico.models.BusEntity;
import com.example.civaRectoTecnico.models.MarcaEntity;

public class BusMapper {

    public static BusEntity toEntity(BusDtoGuardar dto){
        BusEntity b = new BusEntity(dto.getNumeroBus(), dto.getPlaca(), dto.getCaracteristicas(), dto.getActivo());
        MarcaEntity marca = new MarcaEntity(dto.getIdMarca());
        b.setMarca(marca);
        return b;
    }

    public static BusDto toDto(BusEntity bus){
        MarcaEntity marca = bus.getMarca();
        BusDto dto = new BusDto(bus.getId(), bus.getNumeroBus(), bus.getPlaca(), bus.getFechaCreacion(), bus.getCaracteristicas(), bus.getActivo(), marca.getId(), marca.getMarca());
        return dto;
    }
}
