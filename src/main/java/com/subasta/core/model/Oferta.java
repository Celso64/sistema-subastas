package com.subasta.core.model;

import com.subasta.core.Identificable;

import java.util.UUID;

public class Oferta implements Identificable {

    private UUID id;

    private String nombre;

    private UUID idComprador;

    private Double precio;

    private String contacto;

    public Oferta(String nombre, UUID idComprador, Double precio, String contacto) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.idComprador = idComprador;
        this.precio = precio;
        this.contacto = contacto;
    }

    public Oferta(UUID id, String nombre, UUID idComprador, Double precio, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.idComprador = idComprador;
        this.precio = precio;
        this.contacto = contacto;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public UUID getIdComprador() {
        return idComprador;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getContacto() {
        return contacto;
    }
}
