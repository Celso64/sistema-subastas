package com.subasta.infra.storage.sqlite;

import com.subasta.core.Storage;
import com.subasta.core.model.Oferta;
import com.subasta.infra.storage.sqlite.entity.CompradorEntity;
import com.subasta.infra.storage.sqlite.entity.OfertaEntity;
import com.subasta.infra.storage.sqlite.repository.CompradorRepository;
import com.subasta.infra.storage.sqlite.repository.OfertaRepository;
import com.subasta.infra.storage.sqlite.util.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class OfertaSQLStorage implements Storage<Oferta> {
    private OfertaRepository ofertaRepository;
    private CompradorRepository compradorRepository;

    public OfertaSQLStorage(OfertaRepository ofertaRepository, CompradorRepository compradorRepository) {
        this.ofertaRepository = ofertaRepository;
        this.compradorRepository = compradorRepository;
    }


    @Override
    public void save(Oferta object) {
        Optional<CompradorEntity> c = compradorRepository.findById(object.getIdComprador());

        if (c.isEmpty()){
            return;
        }
        OfertaEntity nuevo = new OfertaEntity(object.getNombre(), c.get(), object.getPrecio(), object.getContacto());
        ofertaRepository.save(nuevo);
    }

    @Override
    public Optional<Oferta> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Oferta> getAll() {
        return ofertaRepository
                .findAll()
                .stream()
                .map(Converter::convertOferta)
                .toList();
    }

    @Override
    public Boolean hayRegistros() {
        return ofertaRepository.count() > 0;
    }
}
