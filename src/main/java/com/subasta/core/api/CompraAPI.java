package com.subasta.core.api;

import com.subasta.core.Storage;
import com.subasta.core.model.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CompraAPI {

    private ApplicationEventPublisher eventPublisher;

    private final Storage<Oferta> ofertaStorage;

    public CompraAPI(Storage<Oferta> ofertaStorage, ApplicationEventPublisher applicationEventPublisher) {
        this.ofertaStorage = ofertaStorage;
        this.eventPublisher = applicationEventPublisher;
    }

    public void agregarCompra(String nombre, String idComprador, Double precio, String contacto){
        Oferta nuevaOferta = new Oferta(nombre, UUID.fromString(idComprador), precio, contacto);
        ofertaStorage.save(nuevaOferta);
        eventPublisher.publishEvent(nuevaOferta);
    }

    public List<Oferta> listarOfertas(){
        return ofertaStorage.getAll();
    }
}
