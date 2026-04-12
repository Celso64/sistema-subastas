package com.subasta.ui.compra.dto;

import com.subasta.core.model.Oferta;

public record OfertaShowDTO(String carta, String precio, String comprador, String contacto, String estado) {

    public static OfertaShowDTO fromModel(Oferta ofertaModel){

        String cartaNombre = ofertaModel.getNombre();
        String precioCarta = ofertaModel.getPrecio().toString();
        String compradorId = ofertaModel.getIdComprador().toString();
        String contactoComprador = ofertaModel.getContacto();
        String estado = "PENDIENTE";

       return new OfertaShowDTO(cartaNombre, precioCarta, compradorId, contactoComprador, estado);
    }

    public Object[] toArray(){
        return new Object[]{carta, precio, comprador, contacto, estado};
    }

    public static String[] getTitles(){
        return new String[]{"Carta", "Precio", "Comprador", "Numero de contacto", "Estado"};
    }
}
