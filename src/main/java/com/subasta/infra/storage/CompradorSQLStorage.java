package com.subasta.infra.storage;

import com.subasta.core.Storage;
import com.subasta.core.model.Comprador;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CompradorSQLStorage implements Storage<Comprador> {
    @Override
    public void save(Comprador object) {

    }

    @Override
    public Optional<Comprador> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Comprador> getAll() {
        return List.of();
    }
}
