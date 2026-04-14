package com.subasta.infra.storage.sqlite.repository;

import com.subasta.infra.storage.sqlite.entity.OfertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfertaRepository extends JpaRepository<OfertaEntity, UUID> {
}
