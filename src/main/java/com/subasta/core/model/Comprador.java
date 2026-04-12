package com.subasta.core.model;

import com.subasta.core.Identificable;

import java.util.Arrays;
import java.util.UUID;

public class Comprador implements Identificable {

    private UUID id;

    private String nombre;

    private byte[] logo;

    private String contacto;

    public Comprador(UUID id, String nombre, byte[] logo, String contacto) {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
        this.contacto = contacto;
    }

    public Comprador(String nombre, byte[] logo, String contacto) {
        this.id = UUID.randomUUID();
        this.nombre = nombre;
        this.logo = logo;
        this.contacto = contacto;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getContacto() {
        return contacto;
    }
}
