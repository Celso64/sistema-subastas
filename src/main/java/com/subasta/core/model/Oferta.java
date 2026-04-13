package com.subasta.core.model;

import com.subasta.core.Identificable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Oferta implements Identificable {

    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private UUID id;

    private String nombre;

    private UUID idComprador;

    private Double precio;

    private String contacto;

    private String creada;

    public Oferta(String nombre, UUID idComprador, Double precio, String contacto) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.idComprador = idComprador;
        this.precio = precio;
        this.contacto = contacto;
        this.creada = LocalDate.now().format(formato);
    }

    public Oferta(UUID id, String nombre, UUID idComprador, Double precio, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.idComprador = idComprador;
        this.precio = precio;
        this.contacto = contacto;
        this.creada = LocalDate.now().format(formato);
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

    public String getCreada() {
        return creada;
    }
}
