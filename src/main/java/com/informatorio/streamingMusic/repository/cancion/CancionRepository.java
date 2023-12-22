package com.informatorio.streamingMusic.repository.cancion;

import com.informatorio.streamingMusic.dominio.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface CancionRepository extends JpaRepository<Cancion, UUID> {

    @Query("SELECT c FROM Cancion c WHERE c.artista.nombreArtista = :nombreArtista ORDER BY c.ranking DESC")
    List<Cancion> buscarCancionPorArtistaOrdenadaPorRanking(String nombreArtista);

    @Query("SELECT c FROM Cancion c WHERE " +
            "(:titulo IS NULL OR c.nombreCancion LIKE %:titulo%) AND " +
            "(:genero IS NULL OR c.genero.nombreGenero LIKE %:genero%) AND " +
            "(:artista IS NULL OR c.artista.nombreArtista LIKE %:artista%) AND " +
            "(:album IS NULL OR c.album LIKE %:album%)")
    List<Cancion> buscarCancionesAleatorias(String titulo, String genero, String artista, String album);
}
