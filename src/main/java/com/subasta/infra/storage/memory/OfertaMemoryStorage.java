package com.subasta.infra.storage.memory;

import com.google.gson.Gson;
import com.subasta.core.Storage;
import com.subasta.core.model.Oferta;
import org.springframework.stereotype.Component;

import java.util.*;

public class OfertaMemoryStorage implements Storage<Oferta> {

    private Gson converter;
    private Map<UUID, Oferta> storage;

    public OfertaMemoryStorage(Gson converter) {
        this.converter = converter;
        storage = new HashMap<>();
    }

    @Override
    public void save(Oferta object) {
        String res = converter.toJson(object);
        storage.put(object.getId(), object);
    }

    @Override
    public Optional<Oferta> getById(UUID id) {
        Oferta s = storage.get(id);

        if( Objects.nonNull(s)){
            return Optional.of(s);
        }
        return Optional.empty();
    }

    @Override
    public List<Oferta> getAll() {
        return storage.values().stream().toList();
    }

    @Override
    public Boolean hayRegistros() {
        return !storage.isEmpty();
    }

}
