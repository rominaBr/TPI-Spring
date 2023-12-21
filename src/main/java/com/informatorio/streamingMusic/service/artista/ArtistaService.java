package com.informatorio.streamingMusic.service.artista;

import com.informatorio.streamingMusic.dto.artista.ArtistaDto;
import org.hibernate.engine.jdbc.spi.JdbcServices;

import java.util.UUID;

public interface ArtistaService{
    void crearArtista(ArtistaDto artistaDto);

    ArtistaDto buscarArtistaPorId(UUID idArtista);
}
