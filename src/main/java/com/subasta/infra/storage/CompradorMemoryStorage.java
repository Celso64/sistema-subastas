package com.subasta.infra.storage;

import com.google.gson.Gson;
import com.subasta.core.Storage;
import com.subasta.core.model.Comprador;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Primary
public class CompradorMemoryStorage implements Storage<Comprador> {

    private Gson converter;
    private Map<UUID, Comprador> storage;

    public CompradorMemoryStorage(Gson converter) {
        this.converter = converter;
        storage = new HashMap<>();
    }

    @Override
    public void save(Comprador object) {
        String res = converter.toJson(object);
        storage.put(object.getId(), object);
    }

    @Override
    public Optional<Comprador> getById(UUID id) {
        Comprador s = storage.get(id);
        if( Objects.nonNull(s)){
            return Optional.of(s);
        }
        return Optional.empty();
    }

    @Override
    public List<Comprador> getAll() {
        return storage.values().stream().toList();
    }
}
