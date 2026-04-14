package com.subasta.infra.storage.sqlite.repository;

import com.subasta.infra.storage.sqlite.entity.CompradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompradorRepository extends JpaRepository<CompradorEntity, UUID> {
}
