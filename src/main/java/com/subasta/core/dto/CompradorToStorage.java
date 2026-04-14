package com.subasta.core.dto;

import com.subasta.core.model.Comprador;

public record CompradorToStorage(String nombre, String contacto) {
    public static CompradorToStorage fromModel(Comprador comprador){
        return new CompradorToStorage(comprador.getNombre(), comprador.getContacto());
    }
}
