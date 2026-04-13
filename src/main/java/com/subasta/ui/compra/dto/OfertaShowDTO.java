package com.subasta.ui.compra.dto;

import com.subasta.core.model.Oferta;

import java.time.format.DateTimeFormatter;

public record OfertaShowDTO(String carta, String precio, String comprador, String contacto, String creacion, String estado) {

    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static OfertaShowDTO fromModel(Oferta ofertaModel){

        String cartaNombre = ofertaModel.getNombre();
        String precioCarta = ofertaModel.getPrecio().toString();
        String compradorId = ofertaModel.getIdComprador().toString();
        String contactoComprador = ofertaModel.getContacto();
        String creacion = ofertaModel.getCreada();
        String estado = "PENDIENTE";

       return new OfertaShowDTO(cartaNombre, precioCarta, compradorId, contactoComprador, creacion, estado);
    }

    public Object[] toArray(){
        return new Object[]{carta, precio, comprador, contacto, creacion, estado};
    }

    public static String[] getTitles(){
        return new String[]{"Carta", "Precio", "Comprador", "Numero de contacto", "Creacion", "Estado"};
    }
}
