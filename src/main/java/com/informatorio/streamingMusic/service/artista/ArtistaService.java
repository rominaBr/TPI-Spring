package com.informatorio.streamingMusic.service.artista;

import com.informatorio.streamingMusic.dto.artista.ArtistaDto;
import org.hibernate.engine.jdbc.spi.JdbcServices;

public interface ArtistaService{
    void crearArtista(ArtistaDto artistaDto);
}
