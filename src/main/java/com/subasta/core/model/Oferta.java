package com.subasta.core.model;

import com.subasta.core.Identificable;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Value
public class Oferta implements Identificable {

    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    UUID id;
    String nombre;
    UUID idComprador;
    String nombreComprador;
    Double precio;
    String contacto;
    String creada;

    public Oferta(String nombre, UUID idComprador, Double precio, String contacto) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.idComprador = idComprador;
        this.nombreComprador = "";
        this.precio = precio;
        this.contacto = contacto;
        this.creada = LocalDate.now().format(formato);
    }

    public Oferta(UUID id, String nombre, UUID idComprador, String nombreComprador, Double precio, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.idComprador = idComprador;
        this.nombreComprador = nombreComprador;
        this.precio = precio;
        this.contacto = contacto;
        this.creada = LocalDate.now().format(formato);
    }

    @Override
    public UUID getId() {
        return id;
    }
}
