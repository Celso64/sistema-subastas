package com.subasta.ui.comprador.dto;

import com.subasta.core.model.Comprador;

public record CompradorShowDTO(String nombre, String contacto, String estado) {

    public static CompradorShowDTO fromModel(Comprador comprador){
        String nombreComprador = comprador.getNombre();
        String contactoComprador = comprador.getContacto();

        return new CompradorShowDTO(nombreComprador, contactoComprador, "ACTIVO");
    }

    public Object[] toArray(){
        return new Object[]{nombre, contacto, estado};
    }

    public static String[] getTitles(){
        return new String[]{"Nombre", "Contacto", "Estado"};
    }
}
