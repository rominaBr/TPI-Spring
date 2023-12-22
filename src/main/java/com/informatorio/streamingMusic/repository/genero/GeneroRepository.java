package com.informatorio.streamingMusic.repository.genero;

import com.informatorio.streamingMusic.dominio.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, UUID> {
    @Query("SELECT g FROM Genero g WHERE g.nombreGenero =:nombreGenero")
    Optional<Genero> buscarGeneroPorNombre(String nombreGenero);
}
