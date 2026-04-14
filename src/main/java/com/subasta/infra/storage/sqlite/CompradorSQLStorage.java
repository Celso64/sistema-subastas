package com.subasta.infra.storage.sqlite;

import com.subasta.core.Storage;
import com.subasta.core.model.Comprador;
import com.subasta.infra.storage.sqlite.entity.CompradorEntity;
import com.subasta.infra.storage.sqlite.repository.CompradorRepository;
import com.subasta.infra.storage.sqlite.util.Converter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CompradorSQLStorage implements Storage<Comprador> {

    private CompradorRepository compradorRepository;

    public CompradorSQLStorage(CompradorRepository compradorRepository) {
        this.compradorRepository = compradorRepository;
    }

    @Override
    public void save(Comprador object) {
        CompradorEntity c = new CompradorEntity(object.getNombre(), object.getContacto());
        compradorRepository.save(c);
    }

    @Override
    public Optional<Comprador> getById(UUID id) {
        var res = compradorRepository.findById(id);
        if(res.isEmpty()){
            return Optional.empty();
        }
        var c = res.get();
        return Optional.of(new Comprador(c.getId(), c.getNombre(), null, c.getContacto()));
    }

    @Override
    public List<Comprador> getAll() {
        return compradorRepository
                .findAll()
                .stream()
                .map(Converter::convertComprador)
                .toList();
    }

    @Override
    public Boolean hayRegistros() {
        return compradorRepository.count() > 0;
    }
}
