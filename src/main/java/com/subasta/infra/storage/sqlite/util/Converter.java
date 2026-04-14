package com.subasta.infra.storage.sqlite.util;

import com.subasta.core.model.Comprador;
import com.subasta.core.model.Oferta;
import com.subasta.infra.storage.sqlite.entity.CompradorEntity;
import com.subasta.infra.storage.sqlite.entity.OfertaEntity;

public abstract class Converter {

    public static Comprador convertComprador(CompradorEntity c){
        return new Comprador(c.getId(), c.getNombre(), null, c.getContacto());
    }

    public static Oferta convertOferta(OfertaEntity o){
        return new Oferta(o.getId(), o.getNombre(), o.getComprador().getId(), o.getComprador().getNombre(), o.getPrecio(), o.getContacto());
    }
}
