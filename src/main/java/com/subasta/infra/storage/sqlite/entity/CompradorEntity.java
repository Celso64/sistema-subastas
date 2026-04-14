package com.subasta.infra.storage.sqlite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "comprador")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_comprador")
    private UUID id;

    @Column(name = "nombre", unique = true)
    private String nombre;

    @Column(name = "contacto")
    private String contacto;

    @OneToMany(mappedBy = "comprador", cascade = CascadeType.ALL)
    private List<OfertaEntity> ofertas;

    public CompradorEntity(String nombre, String contacto) {
        this.nombre = nombre;
        this.contacto = contacto;
    }
}
