package com.subasta.infra.storage.sqlite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.UUID;

@Entity
@Table(name = "oferta")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OfertaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_oferta")
    private UUID id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private CompradorEntity comprador;

    private Double precio;

    private String contacto;

    @CreatedDate
    private String creada;

    public OfertaEntity(String nombre, CompradorEntity comprador, Double precio, String contacto) {
        this.nombre = nombre;
        this.comprador = comprador;
        this.precio = precio;
        this.contacto = contacto;
    }
}
