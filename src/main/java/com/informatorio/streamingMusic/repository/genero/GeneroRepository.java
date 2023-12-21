package com.informatorio.streamingMusic.repository.genero;

import com.informatorio.streamingMusic.dominio.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, UUID> {
}
