package com.informatorio.streamingMusic.repository.artista;

import com.informatorio.streamingMusic.dominio.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, UUID> {

    @Query("SELECT a FROM Artista a WHERE a.nombreArtista =:nombreArtista")
    Optional<Artista> buscarArtistaPorNombre(String nombreArtista);
}
