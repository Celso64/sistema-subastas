package com.subasta.core.api;

import com.subasta.core.Storage;
import com.subasta.core.model.Comprador;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorAPI {

    private ApplicationEventPublisher eventPublisher;

    private Storage<Comprador> compradorStorage;

    public CompradorAPI(Storage<Comprador> compradorStorage, ApplicationEventPublisher eventPublisher) {
        this.compradorStorage = compradorStorage;
        this.eventPublisher = eventPublisher;
    }

    public void agregarComprador(String nombre, byte[] logo, String contacto){
        Comprador nuevo = new Comprador(nombre, logo, contacto);
        compradorStorage.save(nuevo);
        eventPublisher.publishEvent(nuevo);
    }

//    public void modificarComprador(UUID idComprador, Optional<String> nombre, Optional<byte[]> logo){
//        compradorStorage.getById(idComprador).ifPresent(comprador -> {
//            nombre.ifPresent(comprador::setNombre);
//            logo.ifPresent(comprador::setLogo);
//            compradorStorage.save(comprador);
//        });
//    }

    public List<Comprador> getCompradores(){
        return compradorStorage.getAll();
    }

    public Boolean hayCompradores(){
        return compradorStorage.hayRegistros();
    }
}
