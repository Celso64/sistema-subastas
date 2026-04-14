package com.subasta.core;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface Storage<T extends Identificable> {

    void save(T object);

    Optional<T> getById(UUID id);

    List<T> getAll();

    Boolean hayRegistros();
}
