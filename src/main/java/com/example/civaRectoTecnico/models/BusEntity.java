package com.example.civaRectoTecnico.models;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Data
@Entity
@Table(name = "bus")
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int numeroBus;

    @Column(length = 20)
    private String placa;

    @Column( name = "fecha_creacion", insertable = false, updatable = false, columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaCreacion;

    @Column(length = 1000)
    private String caracteristicas;
    
    @Column(length = 1)
    private String activo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    @JsonIgnore
    private MarcaEntity marca;

    public BusEntity(int numeroBus, String placa, String caracteristicas, String activo) {
        this.numeroBus = numeroBus;
        this.placa = placa;
        this.caracteristicas = caracteristicas;
        this.activo = activo;
    }
}


